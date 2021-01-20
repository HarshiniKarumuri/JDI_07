package com.flipkart.bean;

/**
 * Admin bean class
 */
public class Admin extends User{

	private int adminId;
	private String name;

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
