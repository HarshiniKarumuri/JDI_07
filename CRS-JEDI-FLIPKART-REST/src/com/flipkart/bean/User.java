package com.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flipkart.constants.ValidationConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * User bean class
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	int userId;

	@NotNull
	@Pattern(message = ValidationConstants.VALID_USERNAME, regexp = "^[0-9a-zA-Z@#$&]+$")
	String username;

	@NotNull
	@Pattern(message = ValidationConstants.VALID_EMAIL, regexp = "^[a-zA-Z0-9_!#$%&�*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	String email;

	@NotNull
	@Pattern(message = ValidationConstants.VALID_PASSWORD , regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
	String password;

	String role;

	String gender;
	String address;

	/**
	 * get the email of the email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set the email of the email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get the address of the user
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * set the address of the user
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * get the password of the user
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set the password of the user
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get the role of the user
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * get the role of the user
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * get the gender of the user
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * set the gender of the user
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * get the user Id
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * set the user Id
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * get the username 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * set the username
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
