package com.flipkart.bean;

/**
 * Student bean class
 */
public class Student extends User{

	private int studentId;
	private String studentName;
	private String branch;
	private boolean hasScholarship;
	private String gender;
	private int isRegistered;

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the name
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the name to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the hasScholarship
	 */
	public boolean isHasScholarship() {
		return hasScholarship;
	}

	/**
	 * @param hasScholarship the hasScholarship to set
	 */
	public void setHasScholarship(boolean hasScholarship) {
		this.hasScholarship = hasScholarship;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the isRegistered
	 */
	public int getIsRegistered() {
		return isRegistered;
	}

	/**
	 * @param isRegistered the isRegistered to set
	 */
	public void setIsRegistered(int isRegistered) {
		this.isRegistered = isRegistered;
	}
}
