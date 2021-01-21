package com.flipkart.dao;

public interface LoginDAOInterface {

    /**
     * fetch credentials from DB and verify authentication
     *
     * @param username
     * @param password
     * @return
     */
    public String login(String username,String password);
}
