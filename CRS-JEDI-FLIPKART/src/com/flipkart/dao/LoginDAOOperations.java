package com.flipkart.dao;

public class LoginDAOOperations implements LoginDAOInterface{

    //TODO: implement data fetch using SQL queries
    @Override
    public String login(String username, String password) {
        //Dummy Data
    	if(username.equals("Amit")) {
            return "Professor";
        }
        else
            return " ";
    }
}
