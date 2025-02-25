package com.practoclone.doctors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practoclone.doctors.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	 @Autowired
	    private DoctorService doctorService;
 
	 @PostMapping("/create")
	 public ResponseEntity<String> create()
	 {
		 return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
	 }
}
