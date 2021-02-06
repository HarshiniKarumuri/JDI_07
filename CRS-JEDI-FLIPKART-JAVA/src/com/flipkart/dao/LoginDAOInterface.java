package com.flipkart.dao;

import java.math.BigInteger;

public interface LoginDAOInterface {

    /**
     * fetch credentials from DB and verify authentication
     *
     * @param userid   userid of the user CRS credentials
     * @param password password of the user CRS credentials
     * @return true if correct credentials else false
     */

    boolean checkCredentials(int userid, String password);

    /**
     * fetch credentials from DB and verify authentication
     *
     * @param userid   userid of the user CRS credentials
     * @param password password of the user CRS credentials
     * @return role of the user -> admin or student or professor
     */
    String login(int userid, String password);
}
