/**
 * 
 */
package com.flipkart.bean;

/**
 * @author mayan
 *
 */
public class Admin extends User{
	int adminId;
	String name;
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
