package com.flipkart.dao;

public interface LoginDAOInterface {

    /**
     * fetch credentials from DB and verify authentication
     *
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);
}
