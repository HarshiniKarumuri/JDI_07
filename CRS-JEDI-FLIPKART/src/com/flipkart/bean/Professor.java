package com.flipkart.bean;

/**
 * Professor bean class
 */
public class Professor extends User{

	private int professorId;
	private String professorName;
	private String email;

	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getProfessorName() {
		return professorName;
	}

	/**
	 * @param professorName the name to set
	 */
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

}
