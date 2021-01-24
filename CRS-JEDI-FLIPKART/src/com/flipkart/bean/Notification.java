/**
 * 
 */
package com.flipkart.bean;

import java.sql.Timestamp;

/**
 * @author harshini
 *
 */
public class Notification {
	
	private int notificationId;
	private String description;
	private int userId;
	private Timestamp timestamp;
	
	/**
	 * 
	 * @return returns time stamp of the notification
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * 
	 * @param timestamp time stamp of notification
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 
	 * @return return user id
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * 
	 * @param userId the user id to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the notificationId
	 */
	public int getNotificationId() {
		return notificationId;
	}
	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
