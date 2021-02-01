package com.flipkart.bean;

import com.flipkart.constants.ValidationConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Professor bean class
 */
public class Professor extends User{

	private int professorId;

	@NotNull
	@Pattern(message = ValidationConstants.ONLY_ALPHABETS_ALLOWED, regexp = "^[a-zA-Z ]+$")
	private String department;

	/**
	 * gets the professor Id
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * set the professor Id
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * get the department of the professor
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * set the department of the professor
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	
}
