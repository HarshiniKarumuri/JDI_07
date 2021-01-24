package com.flipkart.service;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDAOOperation;

public class NotificationOperations implements NotificationInterface{

	public static Logger logger = Logger.getLogger(NotificationOperations.class);
	public static NotificationDAOOperation NotificationDAOOperation = new NotificationDAOOperation(); 
	
	@Override
	public void sendNotification(Notification notification) {
		// TODO Auto-generated method stub
		notification.setTimestamp(new Timestamp(System.currentTimeMillis()));
		NotificationDAOOperation.sendNotification(notification);
	}

}
