package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDAOOperations;
import com.flipkart.dao.CatalogDAOOperations;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * Admin business class
 */
public class AdminOperations implements AdminInterface {
	
	private static Logger logger = Logger.getLogger(AdminOperations.class);
	private final AdminDAOOperations adminDAOOperations = new AdminDAOOperations();
	private final CatalogDAOOperations catalogDAOOperations = new CatalogDAOOperations();

	@Override
	public void viewUser() {
		// TODO Auto-generated method stub
		logger.info("In viewUser");
		
		ArrayList<User> users = adminDAOOperations.viewUser();
		
		for(User user:users) {
			logger.info(String.format("UserName = %s, UserId = %d", user.getUsername(),user.getUserId()));
		}
	}
	
	@Override
	public void addCourseIntoCatalog(Course course) {
		// TODO Auto-generated method stub
		logger.info("In add Course Into Catalouge");
		
	}

	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		logger.info("In delete Course");
		
	}

	@Override
	public void addProfessor(Professor professor,String password) {
		// TODO Auto-generated method stub
		logger.info("In add Professor");
	}
	
	@Override
	public void assignProfessor(Professor professor,int courseId) {
		// TODO Auto-generated method stub
		logger.info("In assign Professor");
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		logger.info("In delete User");
		
	}

	@Override
	public void addAdmin(Admin admin, String password) {
		// TODO Auto-generated method stub
		logger.info("In add admin");
	}

	@Override
	public void viewCatalog() {
		// TODO Auto-generated method stub
		ArrayList<Course> courses = new ArrayList<Course>();
		courses = catalogDAOOperations.viewCatalog();
		
		logger.info(String.format("%-15s", "Course Names"));
		for(Course course:courses) {
			logger.info(String.format("%-15s", course.getCourseName()));
		}
	}

	


}
