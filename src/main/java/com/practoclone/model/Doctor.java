package com.practoclone.model;

public class Doctor {
	
	private long id;
    private String name;
    private String email;
    private String qualification;
    private int experience;
    private int age;
    private long mobileNo;
    private String address;
    private boolean isAvailable;
    
	public Doctor(long id, String name, String email, String qualification, int experience, int age, long mobileNo,
			String address, boolean isAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.qualification = qualification;
		this.experience = experience;
		this.age = age;
		this.mobileNo = mobileNo;
		this.address = address;
		this.isAvailable = isAvailable;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
  
    

}
