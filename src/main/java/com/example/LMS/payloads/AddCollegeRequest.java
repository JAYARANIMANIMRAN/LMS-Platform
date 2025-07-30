package com.example.LMS.payloads;

public class AddCollegeRequest {
    private String collegeName;
    private String collegeCode;

    // Getters & Setters
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }
}
