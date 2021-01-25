package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

public class CatalogDAOOperations implements CatalogDAOInterface {
	
	public static Logger logger = Logger.getLogger(CatalogDAOOperations.class);
	Connection connection = DBUtils.getConnection();

	@Override
	public ArrayList<Course> viewCatalog() {
		// TODO Auto-generated method stub
		
		ArrayList<Course> courses = new ArrayList<Course>();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSES_QUERY);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				course.setCourseName(rs.getString("course_name"));
			}
		} catch(SQLException se) {
			logger.error(se.getMessage());
		}
		return courses;
	}

	@Override
	public Course viewCourse(int courseId) {
		
		Course course1 = new Course();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_CATALOG_QUERY);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				course1.setCourseId(courseId);
				course1.setCourseName(rs.getString("course_name"));
				course1.setDescription(rs.getString("descrition"));
				course1.setFees(rs.getInt("fees"));
				course1.setCapacity(rs.getInt("capacity"));
			}
		} catch(SQLException se) {
			logger.error(se.getMessage());
		}
		
		return course1;
	}

}
