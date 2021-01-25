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
	 * gets the timestamp
	 * @return returns time stamp of the notification
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * sets the timestamp
	 * @param timestamp time stamp of notification
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * gets user Id
	 * @return return user id
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * sets User Id
	 * @param userId the user id to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * gets Notification Id
	 * @return the notificationId
	 */
	public int getNotificationId() {
		return notificationId;
	}
	/**
	 * sets the notification Id
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	/**
	 * gets the Description of the notification
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * sets the Description of the notification
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

}
