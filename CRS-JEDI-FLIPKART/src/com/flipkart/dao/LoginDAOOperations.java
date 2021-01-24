package com.flipkart.dao;

public class LoginDAOOperations implements LoginDAOInterface{

    //TODO: implement data fetch using SQL queries
    @Override
    public String login(int userid, String password) {
        return "Admin";
    }
    
    public boolean checkCredentials(int userid, String password) {
    	return true;
    }
}
