package com.flipkart.bean;

/**
 * Student bean class
 */
public class Student extends User{

	private int studentId;
	private String name;
	private String branch;
	private boolean hasScholarship;
	private String gender;
	private int isRegistered;

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public boolean isHasScholarship() {
		return hasScholarship;
	}
	public void setHasScholarship(boolean hasScholarship) {
		this.hasScholarship = hasScholarship;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getIsRegistered() {
		return isRegistered;
	}
	public void setIsRegistered(int isRegistered) {
		this.isRegistered = isRegistered;
	}
	
}
