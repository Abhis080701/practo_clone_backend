package com.practoclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practoclone.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
	
}
