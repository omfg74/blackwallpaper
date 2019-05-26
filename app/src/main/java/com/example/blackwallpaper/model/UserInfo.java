package com.example.blackwallpaper.model;

public class UserInfo {
    private String lastName;
    private String firstName;
    private String middleName;
    private String email;
    private String phone;
    private String vin;
    private String year;
    private String city;
    private int classId;
    private int dealerId;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getVin() {
        return vin;
    }

    public String getYear() {
        return year;
    }

    public int getClassId() {
        return classId;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }
}
