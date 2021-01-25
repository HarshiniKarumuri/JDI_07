package com.flipkart.bean;

/**
 * Student bean class
 */
public class Student extends User{

	private int studentId;
	private String branch;
	private boolean hasScholarship;
	private boolean isApproved;

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
	 * 
	 * @return returns boolean
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * 
	 * @param isApproved
	 */
	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
}
