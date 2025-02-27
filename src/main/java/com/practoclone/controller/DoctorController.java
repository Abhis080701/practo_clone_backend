package com.practoclone.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.practoclone.model.Doctor;
import com.practoclone.service.DoctorService;
import com.practoclone.util.FileUtil;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/doctors")
	public ResponseEntity<?> getAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return doctors.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Doctors Founds")
				: ResponseEntity.status(HttpStatus.OK).body(doctors);
	}

	@GetMapping("/doctor/{id}")
	public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
	
		try {
			Doctor doctor = doctorService.getDoctorById(id);
			return ResponseEntity.status(HttpStatus.FOUND).body(doctor);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Doctor doctor) throws Exception {
		 MultipartFile imageFile = null;
		 
		 if(doctor.getImagePath()!=null)
		 {
			  imageFile = FileUtil.convertPathToMultipart(doctor.getImagePath());
		 }
		
		return Optional.ofNullable(doctorService.createDoctor(doctor,imageFile))
				.map(doc -> ResponseEntity.status(HttpStatus.CREATED).body(doc.getName() + " Doctor Created !"))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable To Create Doctor"));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
		try {
			doctorService.updateDoctor(id, updatedDoctor);
			return ResponseEntity.ok("Doctor with ID " + id + " updated successfully.");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
		return doctorService.findDoctorById(id).map(doctor -> {
			doctorService.deleteDoctorById(id);
			return ResponseEntity.status(HttpStatus.FOUND).body("Doctor deleted successfully.");
		}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Available "));
	}
}
