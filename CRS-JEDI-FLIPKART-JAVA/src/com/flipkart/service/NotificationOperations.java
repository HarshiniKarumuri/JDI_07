package com.flipkart.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.utils.PrintTabularInterface;
import com.flipkart.utils.StringFormatUtil;
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

	private List<String> getAsList(Notification notification) {
		return new ArrayList<>(Arrays.asList(notification.getTimestamp().toString(), Integer.toString(notification.getUserId()), notification.getDescription(), Integer.toString(notification.getNotificationId())));
	}

	@Override
	public void getNotification(int userId) {
		ArrayList<Notification> notifications = notificationDAOOperation.getNotification(userId);
		List<String> columnNames = Arrays.asList("Timestamp", "User ID", "Description", "Notification ID");
		PrintTabularInterface fn = param -> getAsList((Notification) param);
		StringFormatUtil.printTabular(logger, columnNames, notifications, fn);
	}

}
