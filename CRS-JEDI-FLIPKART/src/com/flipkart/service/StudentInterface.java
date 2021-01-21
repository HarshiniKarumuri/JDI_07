package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * Student business interface
 */
public interface StudentInterface {
	
	void viewCourseCatalog();
	
	void addCourse(Student student,int courseId);
	
	void dropCourse(Student student,int courseId);
	
	void  viewRegisteredCourse(Student student);
	
	void viewGrades(Student student);

	void makePayment(Student student, int paymentMethod, int fees);
}
