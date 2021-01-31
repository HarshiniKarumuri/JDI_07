package com.flipkart.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Admin bean class
 */
public class Admin extends User {

	@NotNull
	@Pattern(message = "Invalid user ID -> Valid user ID contains only digits.", regexp = "^[0-9]+$")
	private int adminId;

	/**
	 * get the Admin ID
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * set the Admin Id
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
