package com.flipkart.service;

import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.ProfessorDAOInterface;
import com.flipkart.dao.ProfessorDAOOperations;
import com.flipkart.dao.StudentDAOInterface;
import com.flipkart.dao.StudentDAOOperations;

/**
 * Student business class
 */
public class StudentOperations implements StudentInterface {
	
	private static final Logger logger = Logger.getLogger(StudentOperations.class);

	StudentDAOInterface studentDao = new StudentDAOOperations();
	public Course viewCourse(int courseId) {
		
		return null;
	}
	
	
	//function to add Course to a particular student
	public void addCourse(Student student,int courseId) {
	
		//TODO:  Exception handling 
		studentDao.addCourse(student,courseId);
	}
	
	
	//function to drop Course for a particular student
	public void dropCourse(Student student,int courseId) {
		
		//TODO:  Exception handling 
		studentDao.dropCourse(student,courseId);
	}
	
	public void  viewRegisteredCourse(Student student) {
		ArrayList<Course> courses=studentDao.getRegisteredCourses(student);
		if(courses.size()==0) {
			logger.info(UIConstants.NO_COURSE_REGISTERED_MESSAGE);
		}
		else {
			logger.info("Course Id\tCourse Name");
			courses.forEach(course -> logger.info(course.getCourseId() +  "\t\t " + course.getCourseName()));
		}
	}
	
	public void viewGrades(Student student) {
		
	}
	
}
