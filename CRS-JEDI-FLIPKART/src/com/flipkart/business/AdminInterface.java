package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

public interface AdminInterface {
	
	public void viewCourse();
	
	public String addCourseIntoCatalouge(Course course);
	
	public void deleteCourse(int courseId);
	
	public String addProfessor(Professor professor);
	
	public String assignProfessor(Professor professor,int courseId);
	
	public void deleteUser(int userId);

}
