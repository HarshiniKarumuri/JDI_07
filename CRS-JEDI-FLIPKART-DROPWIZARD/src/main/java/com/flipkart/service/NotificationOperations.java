package com.flipkart.service;

import java.sql.Timestamp;
import java.util.ArrayList;
<<<<<<< HEAD

=======
import java.util.Arrays;
import java.util.List;

import com.flipkart.utils.PrintTabularInterface;
import com.flipkart.utils.StringFormatUtil;
>>>>>>> 0c649c6c9c7d5d757bbcc6c2f9acb13b19c7f3fb
import org.apache.log4j.Logger;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDAOOperation;

public class NotificationOperations implements NotificationInterface{

	public static Logger logger = Logger.getLogger(NotificationOperations.class);
	private final NotificationDAOOperation notificationDAOOperation = NotificationDAOOperation.getInstance(); 
	
	private static volatile NotificationOperations instance = null;
	 
    // private constructor
    private NotificationOperations() {
    }
 
    public static NotificationOperations getInstance() {
        if (instance == null) {
        	// This is a synchronized block, when multiple threads will access this instance
            synchronized (NotificationOperations.class) {
                instance = new NotificationOperations();
            }
        }
        return instance;
    }
	
	@Override
	public void sendNotification(Notification notification) {
		notification.setTimestamp(new Timestamp(System.currentTimeMillis()));
		notificationDAOOperation.sendNotification(notification);
	}

<<<<<<< HEAD
	@Override
	public void getNotification(int userId) {
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		notifications = notificationDAOOperation.getNotification(userId);
		logger.info("Timestamp   UserId   Description  NotificationId");
		for(Notification notification : notifications) {
			logger.info(notification.getTimestamp() + " " + notification.getUserId() + " " + notification.getDescription() + " " + notification.getNotificationId());
		}
=======
	private List<String> getAsList(Notification notification) {
		return new ArrayList<>(Arrays.asList(notification.getTimestamp().toString(), Integer.toString(notification.getUserId()), notification.getDescription(), Integer.toString(notification.getNotificationId())));
	}

	@Override
	public void getNotification(int userId) {
		ArrayList<Notification> notifications = notificationDAOOperation.getNotification(userId);
		List<String> columnNames = Arrays.asList("Timestamp", "User ID", "Description", "Notification ID");
		PrintTabularInterface fn = param -> getAsList((Notification) param);
		StringFormatUtil.printTabular(logger, columnNames, notifications, fn);
>>>>>>> 0c649c6c9c7d5d757bbcc6c2f9acb13b19c7f3fb
	}

}
