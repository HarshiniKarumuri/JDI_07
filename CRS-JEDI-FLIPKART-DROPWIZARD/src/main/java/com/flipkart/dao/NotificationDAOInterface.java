package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Notification;

public interface NotificationDAOInterface {

	/**
	 * sends the notification
	 * @param notification the notification to be sent
	 */
	void sendNotification(Notification notification);
	
	/**
	 * Fetches the list of notification of particular user
	 * 
	 * @param userId unique identifier for student
	 * @return list of notification
	 */
	ArrayList<Notification> getNotification(int userId);
	
}
