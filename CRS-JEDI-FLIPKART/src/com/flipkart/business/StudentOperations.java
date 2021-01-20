package com.flipkart.business;


import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import org.apache.log4j.Logger;

/**
 * Student business class
 */
public class StudentOperations implements StudentInterface {
	
	private static Logger logger = Logger.getLogger(StudentOperations.class);
	
	public Course viewCourse(int courseId) {
		logger.info("In view Course");
		return null;
	}
	
	public void addCourse(Student student,int courseId) {
		logger.info("In add course");
	}
	
	public void dropCourse(Student student,int courseId) {
		logger.info("In drop course");
	}
	
	public void  viewRegisteredCourse(Student student) {
		logger.info("In view registered course");
	}
	
	public void viewGrades(Student student) {
		logger.info("In view grades");
	}
	
}
