package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

/**
 * Admin business interface
 */
public interface AdminInterface {

	/**
	 * To see the list of users in CRS
	 */
	public void viewUser();
	
	/**
	 * Register a professor user into CRS
	 *
	 * @param professor represents a new professor to be added into DB
	 * @param password password for professor account
	 */
	public void addProfessor(Professor professor,String password);

	/**
	 * Assign a professor to a course offered
	 *
	 * @param professor professor object who is assigned a course
	 * @param courseId unique identifier of course
	 */
	public void assignProfessorToCourse(int professorId, int courseId);
	
	/**
	 * Register a admin user in CRS
	 *
	 * @param admin admin object which is added into DB
	 * @param password password for professor account
	 */
	public void addAdmin(Admin admin,String password);

	/**
	 * Delete an existing account of a user in CRS
	 *
	 * @param userId unique identifier of user to be deleted
	 */
	public void deleteUser(int userId);

	/**
	 * To view the offered courses from courses catalog
	 */
	public void viewCoursesOffered();

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
	
	public void viewPendingApprovalStudent();
}
