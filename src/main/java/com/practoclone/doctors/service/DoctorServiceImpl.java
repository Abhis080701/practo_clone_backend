package com.practoclone.doctors.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practoclone.doctors.model.Doctor;
import com.practoclone.doctors.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	 @Autowired
	    private DoctorRepository doctorRepository;

	@Override
	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Optional<Doctor> findDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
 

}
