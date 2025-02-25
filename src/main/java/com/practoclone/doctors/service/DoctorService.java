package com.practoclone.doctors.service;

import java.util.Optional;

import com.practoclone.doctors.model.Doctor;

public interface DoctorService {
	Doctor createDoctor(Doctor doctor);

	Optional<Doctor> findDoctorById(Long id);

	void deleteDoctorById(Long id);


	Doctor updateDoctor(Long id, Doctor updatedDoctor);  // Method to update a doctor by ID}

}