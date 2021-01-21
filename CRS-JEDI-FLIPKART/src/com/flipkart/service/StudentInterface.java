package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * Student business interface
 */
public interface StudentInterface {
	
	Course viewCourse(int courseId);
	
	void addCourse(Student student,int courseId);
	
	void dropCourse(Student student,int courseId);
	
	void  viewRegisteredCourse(Student student);
	
	void viewGrades(Student student);

}
