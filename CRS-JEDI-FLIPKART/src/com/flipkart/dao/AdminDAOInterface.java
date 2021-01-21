package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;

public interface AdminDAOInterface {
	

	/**
	 * To see the List of Users
	 */
	public ArrayList<User> viewUser();

	
	
	/**
	 * 
	 * @param course a new course to add into catalog 
	 */
	public void addCourseIntoCatalog(Course course);

	
	
	/**
	 * 
	 * @param courseId unique identifier of the course to be deleted 
	 */
	public void deleteCourse(int courseId);

	
	
	/**
	 * 
	 * @param professor represents a new professor to be added into DB
	 */
	public void addProfessor(Professor professor);

	
	
	/**
	 * 
	 * @param professor professor object who is assigned a course
	 * @param courseId unique identifier of course
	 */
	public void assignProfessor(Professor professor, int courseId);

	
	
	/**
	 * 
	 * @param userId unique identifier of user to be deleted
	 */
	public void deleteUser(int userId);
	
	
}
