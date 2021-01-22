package com.flipkart.bean;

/**
 * Admin bean class
 */
public class Admin extends User {

	private int adminId;

	/**
	 * @return the adminId
	 */

	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
