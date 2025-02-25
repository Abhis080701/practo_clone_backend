package com.practoclone.doctors.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practoclone.doctors.model.Doctor;
import com.practoclone.doctors.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	 @Autowired
	    private DoctorService doctorService;
 
	 @PostMapping("/create")
	 public ResponseEntity<String> create(@RequestBody Doctor doctor)
	 {
		 
	 return Optional.ofNullable(doctorService.createDoctor(doctor))
			 .map(doc->ResponseEntity.status(HttpStatus.CREATED).body(doc.getName()+ " Doctor Created !"))
             .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable To Create Doctor"))			 
			;
	 }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
	        return doctorService.findDoctorById(id)
	                .map(doctor -> {
	                    doctorService.deleteDoctorById(id);
	                    return ResponseEntity.ok("Doctor deleted successfully.");
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }
}
