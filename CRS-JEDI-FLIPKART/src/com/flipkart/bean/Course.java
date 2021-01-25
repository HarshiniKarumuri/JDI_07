package com.flipkart.bean;

/**
 * Course bean class
 */
public class Course {

	private int courseId;
	private String courseName;
	private String description;
	private int fees;
	private int capacity;
	
	/**
	 * get the capacity of the course
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * set the capacity of the course
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * get the Course Id
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * Set the course Id
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * get the course name
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * set the course name
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * get the Description of the course
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets the description of the course
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * gets the fees of the course
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}

	/**
	 * sets the fees of the course
	 * @param l the fees to set
	 */
	public void setFees(int l) {
		this.fees = l;
	}

}
