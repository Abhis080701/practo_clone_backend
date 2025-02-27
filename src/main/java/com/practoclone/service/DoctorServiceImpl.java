package com.practoclone.service;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practoclone.model.Doctor;
import com.practoclone.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	 @Autowired
	    private DoctorRepository doctorRepository;
	 
	 private static final String IMAGE_DIRECTORY =  "src/main/resources/static/images/";

	@Override
	public Doctor createDoctor(Doctor doctor,MultipartFile imageFile) throws Exception {
		   if (!imageFile.isEmpty()) {
	            // Generate unique file name
	            String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
	            String filePath = IMAGE_DIRECTORY + fileName;

	            // Save file to folder
	            File file = new File(filePath);
	            imageFile.transferTo(file);

	            // Store relative path in DB
	            doctor.setImagePath("images/" + fileName);
	        }
		return doctorRepository.save(doctor);
	}
	
	public Optional<Doctor> findDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

	@Override
	public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
		return doctorRepository.findById(id)
				.map(existingDoctor -> {
					// Update only non-null fields from updatedDoctor
					if (updatedDoctor.getName() != null) existingDoctor.setName(updatedDoctor.getName());
					if (updatedDoctor.getEmail() != null) existingDoctor.setEmail(updatedDoctor.getEmail());
					if (updatedDoctor.getSpecialization() != null) existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
					if (updatedDoctor.getQualification() != null) existingDoctor.setQualification(updatedDoctor.getQualification());
					if (updatedDoctor.getExperience() != 0) existingDoctor.setExperience(updatedDoctor.getExperience());
					if (updatedDoctor.getAge() != 0) existingDoctor.setAge(updatedDoctor.getAge());
					if (updatedDoctor.getMobileNo() != 0) existingDoctor.setMobileNo(updatedDoctor.getMobileNo());
					if (updatedDoctor.getAddress() != null) existingDoctor.setAddress(updatedDoctor.getAddress());

					return doctorRepository.save(existingDoctor);  // Save updated doctor
				})
				.orElseThrow(() -> new RuntimeException("Doctor with ID " + id + " not found."));
	}



	@Override
	public List<Doctor> getAllDoctors( ) {
		
		return doctorRepository.findAll();
	}


	@Override
	public Doctor getDoctorById(Long id) {
		// TODO Auto-generated method stub
		 return doctorRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Doctor with ID " + id + " not found"));
	}
}



