/**
 * 
 */
package com.flipkart.bean;

/**
 * @author mayan
 *
 */
public class Student extends User{

	int studentId;
	String name;
	String branch;
	boolean hasScholarship;
	String gender;
	int isRegistered;
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