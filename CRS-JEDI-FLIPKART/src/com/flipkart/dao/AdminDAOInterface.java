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
	ArrayList<User> viewUser();

	/**
	 * Remove an offered course
	 *
	 * @param course a new course to add into catalog 
	 */
	void addCourseToOffer(Course course);

	/**
	 * Add course to offered courses from courses catalog
	 *
	 * @param courseId unique identifier of the course to be deleted 
	 */
	void removeOfferedCourse(int courseId);

	/**
	 * Register a professor user into CRS
	 *
	 * @param professor represents a new professor to be added into DB
	 * @param password password for professor account
	 */
	void addProfessor(Professor professor, String password);

	/**
	 * Assign a professor to a course offered
	 *
	 * @param professor professor object who is assigned a course
	 * @param courseId unique identifier of course
	 */
	void assignProfessorToCourse(Professor professor, int courseId);

	/**
	 * Delete an existing account of a user in CRS
	 *
	 * @param userId unique identifier of user to be deleted
	 */
	void deleteUser(int userId);

	/**
	 * Register an admin user in CRS
	 *
	 * @param admin admin object which is added into DB
	 * @param password password for professor account
	 */
	void addAdmin(Admin admin, String password);

	/**
	 * fetch details of admin
	 *
	 * @param username unique identifier of the admin user
	 * @return admin object whose username matches the input
	 */
	Admin getAdminDetails(String username);
}
