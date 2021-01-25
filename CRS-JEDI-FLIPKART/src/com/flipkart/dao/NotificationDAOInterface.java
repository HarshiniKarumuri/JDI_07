package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Notification;

public interface NotificationDAOInterface {

	/**
	 * 
	 * @param notification the notification to be sent
	 */
	public void sendNotification(Notification notification);
	
	/**
	 * Fetches the list of notification of particular user
	 * 
	 * @param studentId unique identifier for student
	 * @return list of notification
	 */
	public ArrayList<Notification> getNotification(int userId);
	
}
