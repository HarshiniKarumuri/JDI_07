package com.flipkart.utils;

import com.flipkart.constants.UIConstants;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    private static Connection connection = null;
    private static final Logger logger = Logger.getLogger(DBUtils.class);

    public static Connection getConnection() {

        if (connection == null) {
            String user, url, password;
            try {
                Properties prop = new Properties();
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                url = prop.getProperty("url");
                user = prop.getProperty("user");
                password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException | IOException e) {
                logger.error(e.getMessage());
            }
        }
        System.out.println(UIConstants.SUCCESS_DB_CONNECT_MESSAGE);
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        System.out.println(UIConstants.SUCCESS_DB_DISCONNECT_MESSAGE);
    }
}
