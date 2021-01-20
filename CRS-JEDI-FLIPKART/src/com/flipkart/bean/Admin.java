package com.flipkart.bean;

/**
 * Admin bean class
 */
public class Admin extends User {

	private int adminId;
	private String adminName;

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

	/**
	 * @return the name
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName the name to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}
