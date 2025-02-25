package com.practoclone.doctors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practoclone.doctors.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	 @Autowired
	    private DoctorRepository doctorRepository;
}
