package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;

public interface AdminDAOInterface {

	/**
	 * To get the list of user registered in CRS
	 */
	ArrayList<User> viewUser();

	/**
	 * Register a professor user into CRS
	 *
	 * @param professor represents a new professor to be added into DB
	 * @param password password for professor account
	 * @return returns professor Id
	 */
	int addProfessor(Professor professor, String password);

	/**
	 * Assign a professor to a course offered
	 *
	 * @param professorId unique identifier of professor
	 * @param courseId unique identifier of course
	 */
	void assignProfessorToCourse(int professorId, int courseId);

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
	 * @return returns the admin Id
	 */
	int addAdmin(Admin admin, String password);

	/**
	 * fetch details of admin
	 *
	 * @param userId unique identifier of the admin user
	 * @return admin object whose username matches the input
	 */
	Admin getAdminDetails(int userId);
	
	/**
	 * Adds a new catalog 
	 * 
	 * @param catlogId unique identifier of catalog
	 * @param catalogName catalog name
	 */
	int addCatalog(int catlogId, String catalogName);
	
	/**
	 * 
	 * @param catalogId unique catalog identifier
	 */
	void removeCatalog(int catalogId);
	
	/**
	 * Adds a new course into catalog
	 * 
	 * @param course a new course to add into catalog
	 * @param catalogId unique catalog identifier
	 */
	int addCourseIntoCatalog(Course course, int catalogId);
	
	/**
	 * Removes a course from catalog
	 * 
	 * @param courseId a unique course identifier
	 */
	void removeCourseFromCatalog(int courseId);

	/**
	 * Remove an offered course
	 *
	 * @param courseId course to add into offered Courses
	 * @param catalogId unique catalog identifier
	 */
	int addCourseToOffer(int courseId, int catalogId);

	/**
	 * Add course to offered courses from courses catalog
	 *
	 * @param courseId unique identifier of the course to be removed from offered courses 
	 */
	void removeOfferedCourse(int courseId, int catalogId);
	
	/**
	 * To approve a student for the registration
	 * @param studentId unique student identifier
	 */
	int approveStudent(int studentId);
	
	ArrayList<Student> viewPendingApprovalStudent();
}