package com.practoclone.service;

import java.util.List;
import java.util.Optional;

import com.practoclone.model.Doctor;

public interface DoctorService {
	Doctor createDoctor(Doctor doctor); // create Doctor

	List<Doctor> getAllDoctors(); // Fetch Doctors
	
	Doctor getDoctorById(Long id);

	Optional<Doctor> findDoctorById(Long id);

	void deleteDoctorById(Long id);

	Doctor updateDoctor(Long id, Doctor updatedDoctor); // Method to update a doctor by ID

}