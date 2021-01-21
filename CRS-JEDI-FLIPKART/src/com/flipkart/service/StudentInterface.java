package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * Student business interface
 */
public interface StudentInterface {
	
	public Course viewCourse(int courseId);
	
	public void addCourse(Student student,int courseId);
	
	public void dropCourse(Student student,int courseId);
	
	public void  viewRegisteredCourse(Student student);
	
	public void viewGrades(Student student);

}