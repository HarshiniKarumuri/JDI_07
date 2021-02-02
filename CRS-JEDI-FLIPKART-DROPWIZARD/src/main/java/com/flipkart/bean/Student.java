package com.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flipkart.constants.ValidationConstants;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Student bean class
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student extends User{

	private int studentId;

	@NotNull
	@Pattern(message = ValidationConstants.ONLY_ALPHABETS_ALLOWED, regexp = "^[a-zA-Z ]+$")
	private String branch;

	@NotNull
	@Pattern(regexp = "^true$|^false$", message = ValidationConstants.ONLY_BOOLEAN_ALLOWED)
	private boolean hasScholarship;

	@NotNull
	@Pattern(regexp = "^true$|^false$", message = ValidationConstants.ONLY_BOOLEAN_ALLOWED)
	private boolean isApproved;

	/**
	 * get the student Id
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * set the student Id
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * get the branch of the student
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * set the branch of the student
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * get the scholarship status of the student
	 * @return the hasScholarship
	 */
	public boolean getHasScholarship() {
		return hasScholarship;
	}

	/**
	 * set the scholarship status of the student
	 * @param hasScholarship 'True' if the student has a scholarship, 'False' otherwise 
	 */
	public void setHasScholarship(boolean hasScholarship) {
		this.hasScholarship = hasScholarship;
	}

	/**
	 * get the status of the approval
	 * @return returns boolean
	 */
	public boolean getIsApproved() {
		return isApproved;
	}

	/**
	 * set the status of the approval 
	 * @param isApproved 'True' if the student is approved, 'False' otherwise
	 */
	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
}
