package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CatalogDAOOperations implements CatalogDAOInterface {

    private static final Logger logger = Logger.getLogger(CatalogDAOOperations.class);
    Connection connection = DBUtils.getConnection();
    
    private static volatile CatalogDAOOperations instance = null;
	 
    // private constructor
    private CatalogDAOOperations() {
    }
 
    public static CatalogDAOOperations getInstance() {
        if (instance == null) {
        	// This is a synchronized block, when multiple threads will access this instance
            synchronized (CatalogDAOOperations.class) {
                instance = new CatalogDAOOperations();
            }
        }
        return instance;
    }

    @Override
    public ArrayList<Course> viewCoursesCatalog() {

        ArrayList<Course> courses = new ArrayList<Course>();
        PreparedStatement stmt;
        ResultSet result;

        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSES_QUERY);
            result = stmt.executeQuery();
            while (result.next()) {
                Course course = new Course();
                course.setCourseId(result.getInt("course_id"));
                course.setCourseName(result.getString("course_name"));
                course.setDescription(result.getString("description"));
                course.setFees(result.getInt("fees"));
                course.setCapacity(result.getInt("capacity"));
                courses.add(course);
            }
            stmt.close();
        } catch (Exception se) {
            logger.error(se.getMessage());
        }

        return courses;
    }

    @Override
    public ArrayList<Course> viewCoursesOffered() {

        ArrayList<Course> courses = new ArrayList<Course>();
        PreparedStatement stmt;
        ResultSet result;

        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_OFFERED_COURSE);
            result = stmt.executeQuery();
            while (result.next()) {
                Course course = new Course();
                course.setCourseId(result.getInt("course_id"));
                course.setCourseName(result.getString("course_name"));
                course.setDescription(result.getString("description"));
                course.setFees(result.getInt("fees"));
                course.setCapacity(result.getInt("capacity"));
                courses.add(course);
            }
            stmt.close();
        } catch (Exception se) {
            logger.error(se.getMessage());
        }

        return courses;
    }

    @Override
    public Course viewCourseDetails(int courseId) {

        Course course = null;
        PreparedStatement stmt;
        ResultSet result;

        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSE_QUERY);
            stmt.setInt(1, courseId);
            result = stmt.executeQuery();
            while (result.next()) {
                course = new Course();
                course.setCourseId(result.getInt("course_id"));
                course.setCourseName(result.getString("course_name"));
                course.setDescription(result.getString("description"));
                course.setFees(result.getInt("fees"));
                course.setCapacity(result.getInt("capacity"));
            }
            stmt.close();
        } catch (Exception se) {
            logger.error(se.getMessage());
        }

        return course;
    }

    @Override
    public boolean checkCourseOffered(int courseId) {

        PreparedStatement stmt;
        ResultSet result;

        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.CHECK_COURSE_OFFERED_QUERY);
            stmt.setInt(1, courseId);
            result = stmt.executeQuery();
            result.next();
            if (result.getInt(1) > 0) {
                return true;
            }
            stmt.close();
        } catch (Exception se) {
            logger.error(se.getMessage());
        }

        return false;
    }

}
