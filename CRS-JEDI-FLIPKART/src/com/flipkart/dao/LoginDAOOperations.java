package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

public class LoginDAOOperations implements LoginDAOInterface{
	
	private static final Logger logger = Logger.getLogger(LoginDAOOperations.class);
	Connection connection = DBUtils.getConnection();
	
	private static volatile LoginDAOOperations instance = null;
	 
    // private constructor
    private LoginDAOOperations() {
    }
 
    public static LoginDAOOperations getInstance() {
        if (instance == null) {
        	// This is a synchronized block, when multiple threads will access this instance
            synchronized (LoginDAOOperations.class) {
                instance = new LoginDAOOperations();
            }
        }
        return instance;
    }

    //TODO: implement data fetch using SQL queries
    @Override
    public String login(int userid, String password) {
    	PreparedStatement stmt = null;
    	String role = "";
    	try {
			stmt = connection.prepareStatement(SQLQueriesConstants.LOGIN_QUERY);
			stmt.setLong(1, userid);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				role = rs.getString("role");
			}
		}catch(SQLException se){
			logger.error(se.getMessage());
		}
        return role;
    }
    
    public boolean checkCredentials(int userid, String password) {
    	PreparedStatement stmt = null;
    	String pswd = "";
    	try {
    		stmt = connection.prepareStatement(SQLQueriesConstants.CHECK_CREDENTIALS_QUERY);
    		stmt.setLong(1, userid);
    		ResultSet rs = stmt.executeQuery();
		
    		while(rs.next()) {
    			pswd = rs.getString("password");
    		}
    	} catch(SQLException se) {
    			logger.error(se.getMessage());
    	}
    	return password.equals(pswd);
    }
}
