package com.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flipkart.constants.ValidationConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Course bean class
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {

	@NotNull
	@Pattern(message = ValidationConstants.ONLY_INTEGERS_ALLOWED, regexp = "^[0-9]+$")
	private int catalogId;

	@NotNull
	@Pattern(message = ValidationConstants.ONLY_INTEGERS_ALLOWED, regexp = "^[0-9]+$")
	private int courseId;

	@NotNull
	@Pattern(message = ValidationConstants.ONLY_ALPHABETS_ALLOWED, regexp = "^[a-zA-Z ]+$")
	private String courseName;

	@NotNull
	@Pattern(message = ValidationConstants.ONLY_INTEGERS_ALLOWED, regexp = "^[0-9]+$")
	private int fees;

	@NotNull
	@Size(min = 3, max = 10, message = ValidationConstants.COURSE_CAPACITY_VIOLATED)
	private int capacity;

	private String description;


	/**
	 * get the catalog Id of the course
	 *
	 * @return catalog Id
	 */
	public int getCatalogId() {
		return catalogId;
	}

	/**
	 * set the catalog Id of the course
	 *
	 * @param catalogId catalog Id of the course
	 */
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * get the capacity of the course
	 *
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * set the capacity of the course
	 *
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * get the Course Id
	 *
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * Set the course Id
	 *
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * get the course name
	 *
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * set the course name
	 *
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * get the Description of the course
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets the description of the course
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * gets the fees of the course
	 *
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}

	/**
	 * sets the fees of the course
	 *
	 * @param l the fees to set
	 */
	public void setFees(int l) {
		this.fees = l;
	}

}