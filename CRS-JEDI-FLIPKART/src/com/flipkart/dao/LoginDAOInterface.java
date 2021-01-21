package com.flipkart.dao;

public interface LoginDAOInterface {

    /**
     * fetch credentials from DB and verify authentication
     *
     * @param username username of the user CRS credentials
     * @param password password of the user CRS credentials
     * @return role of the user admin or student or professor
     */
    String login(String username,String password);
}
