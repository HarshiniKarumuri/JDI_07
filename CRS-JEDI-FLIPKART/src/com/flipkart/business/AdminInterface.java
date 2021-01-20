package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

/**
 * Admin business inteface
 */
public interface AdminInterface {

	public void viewCourse();

	String addCourseIntoCatalog(Course course);

	public void deleteCourse(int courseId);

	public String addProfessor(Professor professor);

	String assignProfessor(Professor professor, int courseId);

	public void deleteUser(int userId);

}
