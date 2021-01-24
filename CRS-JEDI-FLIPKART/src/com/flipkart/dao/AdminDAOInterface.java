package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;

public interface AdminDAOInterface {

	/**
	 * To get the list of user registered in CRS
	 */
	public ArrayList<User> viewUser();

	/**
	 * Register a professor user into CRS
	 *
	 * @param professor represents a new professor to be added into DB
	 * @param password password for professor account
	 * @return returns professor Id
	 */
	public int addProfessor(Professor professor, String password);

	/**
	 * Assign a professor to a course offered
	 *
	 * @param professorId unique identifier of professor
	 * @param courseId unique identifier of course
	 */
	public void assignProfessorToCourse(int professorId, int courseId);

	/**
	 * Delete an existing account of a user in CRS
	 *
	 * @param userId unique identifier of user to be deleted
	 */
	public void deleteUser(int userId);

	/**
	 * Register an admin user in CRS
	 *
	 * @param admin admin object which is added into DB
	 * @param password password for professor account
	 * @return returns the admin Id
	 */
	public int addAdmin(Admin admin, String password);

	/**
	 * fetch details of admin
	 *
	 * @param username unique identifier of the admin user
	 * @return admin object whose username matches the input
	 */
	public Admin getAdminDetails(int userId);
	
	/**
	 * Adds a new catalog 
	 * 
	 * @param catlogId unique identifier of catalog
	 * @param catalogName catalog name
	 */
	public void addCatalog(int catlogId,String catalogName);
	
	/**
	 * 
	 * @param catalogId unique catalog identifier
	 */
	public void removeCatalog(int catalogId);
	
	/**
	 * Adds a new course into catalog
	 * 
	 * @param course a new course to add into catalog
	 * @param catalogId unique catalog identifier
	 */
	public void addCourseIntoCatalog(Course course,int catalogId);
	
	/**
	 * Removes a course from catalog
	 * 
	 * @param courseId a unique course identifier
	 * @param catalogId unique catalog identifier
	 */
	public void removeCourseFromCatalog(int courseId);
	
	/**
	 * Remove an offered course
	 *
	 * @param course course to add into offered Courses 
	 */
	public void addCourseToOffer(int courseId,int catalogId);

	/**
	 * Add course to offered courses from courses catalog
	 *
	 * @param courseId unique identifier of the course to be removed from offered courses 
	 */
	public void removeOfferedCourse(int courseId,int catalogId);
	
	public void approveStudent(int studentId);
}
