package com.flipkart.dao;

public class LoginDaoImpl implements LoginDao {
	
	
	//To Get Credentials from DB
	public String login(String username,String password) {
		if(username.equals("Amit")) {
			return "Professor";
		}
		else
			return " ";
	}
	
}
