package com.practoclone.doctors.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practoclone.doctors.model.Doctor;
import com.practoclone.doctors.service.DoctorService;

@RestController
@RequestMapping("/api/v1")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@PostMapping("/doctor/create")
	public ResponseEntity<String> create(@RequestBody Doctor doctor) {

		return Optional.ofNullable(doctorService.createDoctor(doctor))
				.map(doc -> ResponseEntity.status(HttpStatus.CREATED).body(doc.getName() + " Doctor Created !"))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable To Create Doctor"));
	}

	@PutMapping("/doctor/{id}")
	public ResponseEntity<String> updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
		try {
			Doctor updatedDoc = doctorService.updateDoctor(id, updatedDoctor);
			return ResponseEntity.ok("Doctor with ID " + id + " updated successfully.");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
		return doctorService.findDoctorById(id).map(doctor -> {
			doctorService.deleteDoctorById(id);
			return ResponseEntity.ok("Doctor deleted successfully.");
		}).orElse(ResponseEntity.notFound().build());
	}
}
