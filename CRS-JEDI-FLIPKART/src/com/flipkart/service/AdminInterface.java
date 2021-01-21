package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

/**
 * Admin business interface
 */
public interface AdminInterface {

	/**
	 * To see the List of Users
	 */
	public void viewUser();

	
	
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
	 * @param password password for professor account
	 */
	public void addProfessor(Professor professor,String password);

	
	
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
	
	
	/**
	 * 
	 * @param admin admin object which is added into DB
	 * @param password password for professor account
	 */
	public void addAdmin(Admin admin,String password);
	
	/**
	 * To view the course catalog
	 */
	public void viewCatalog();

}
