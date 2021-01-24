package com.flipkart.dao;

import com.flipkart.bean.Notification;

public interface NotificationDAOInterface {

	/**
	 * 
	 * @param notification the notification to be sent
	 */
	public void sendNotification(Notification notification);
	
}
