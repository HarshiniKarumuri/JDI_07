package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Notification;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

public class NotificationDAOOperation implements NotificationDAOInterface{
	
	public static Logger logger = Logger.getLogger(NotificationDAOOperation.class);
	Connection connection = DBUtils.getConnection();
	
	private static volatile NotificationDAOOperation instance = null;
	 
    // private constructor
    private NotificationDAOOperation() {
    }
 
    public static NotificationDAOOperation getInstance() {
        if (instance == null) {
        	// This is a synchronized block, when multiple threads will access this instance
            synchronized (NotificationDAOOperation.class) {
                instance = new NotificationDAOOperation();
            }
        }
        return instance;
    }
	
	@Override
	public void sendNotification(Notification notification) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.SEND_NOTIFICATION);
			statement.setInt(1,notification.getUserId());
			statement.setString(2, notification.getDescription());
			int rows = statement.executeUpdate();
			logger.info(rows + " notification added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public ArrayList<Notification> getNotification(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.GET_NOTIFICATION);
			statement.setInt(1, userId);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()) {
				Notification notification = new Notification();
				notification.setNotificationId(rs.getInt(1));
				notification.setUserId(userId);
				notification.setDescription(rs.getString(3));
				notification.setTimestamp(rs.getTimestamp(4));
				
				notifications.add(notification);
			}
			int rows = notifications.size();
			logger.info(rows + " notification fetched");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return notifications;
	}
	
	

}
