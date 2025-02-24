package com.practoclone.model;

public class Doctor {
    private String FullName;
    private String Email;
    private long Phoneno;
    private int Age;
    private String City;

    //Default Constructor
    public Doctor(){}

    public Doctor(String FullName, String Email, long Phoneno, int Age, String City) {
        this.FullName = FullName;
        this.Email = Email;
        this.Phoneno = Phoneno;
        this.Age = Age;
        this.City = City;
    }

    //Getter and Setters
    public String getFullName() {
        return FullName;
    }
    public void setFullName(String fullName) {
        this.FullName = fullName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public long getPhoneno() {
        return Phoneno;
    }
    public void setPhoneno(long phoneno) {
        this.Phoneno = phoneno;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        this.Age = age;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {

        this.City = city;
    }




}
