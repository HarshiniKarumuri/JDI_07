package com.flipkart.dao;

public interface LoginDAOInterface {
	
	/**
     * fetch credentials from DB and verify authentication
     *
     * @param userid userid of the user CRS credentials
     * @param password password of the user CRS credentials
     * @return true if correct credentials else false
     */
	
	public boolean checkCredentials(int userid, String password);

    /**
     * fetch credentials from DB and verify authentication
     *
     * @param userid userid of the user CRS credentials
     * @param password password of the user CRS credentials
     * @return role of the user -> admin or student or professor
     */
    public String login(int userid, String password);
}
