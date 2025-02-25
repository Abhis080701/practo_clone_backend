package com.practoclone.doctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practoclone.doctors.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
