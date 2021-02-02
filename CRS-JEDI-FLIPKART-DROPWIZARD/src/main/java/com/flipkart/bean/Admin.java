package com.flipkart.bean;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Admin bean class
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Admin extends User {

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
