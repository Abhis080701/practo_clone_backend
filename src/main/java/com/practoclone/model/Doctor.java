package com.practoclone.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="image_path")
	private String imagePath; 

	@Column(name = "email", unique = true)
	private String email;

	@Column(name ="specialization")
	private String specialization;
	
	@Column(name = "qualification")
	private String qualification;

	@Column(name = "experience")
	private int experience;

	@Column(name = "age")
	private int age;

	@Column(name = "mobile_no")
	private long mobileNo;

	@Column(name = "address")
	private String address;

	@Column(name = "available")
	private boolean available;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(long id, String name, String imagePath, String email, String specialization, String qualification,
			int experience, int age, long mobileNo, String address, boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.imagePath = imagePath;
		this.email = email;
		this.specialization = specialization;
		this.qualification = qualification;
		this.experience = experience;
		this.age = age;
		this.mobileNo = mobileNo;
		this.address = address;
		this.available = available;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	

}
