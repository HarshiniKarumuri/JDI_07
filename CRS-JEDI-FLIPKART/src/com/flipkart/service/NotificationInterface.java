package com.flipkart.service;

import com.flipkart.bean.Notification;

public interface NotificationInterface {
	
	/**
	 * 
	 * @param notification notification to be sent
	 */
	public void sendNotification(Notification notification);

	/**
	 * 
	 * @param userId unique identifier of user
	 */
	public void getNotification(int userId);
}
