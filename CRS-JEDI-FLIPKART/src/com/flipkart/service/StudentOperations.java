package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.StudentDAOInterface;
import com.flipkart.dao.StudentDAOOperations;
import com.flipkart.exception.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Student service class
 */
public class StudentOperations implements StudentInterface {

    private static final Logger logger = Logger.getLogger(StudentOperations.class);

    private final StudentDAOInterface studentDAOOperations = StudentDAOOperations.getInstance();
    private final NotificationOperations notificationOperations = NotificationOperations.getInstance();
    
    private static volatile StudentOperations instance = null;
	 
    // private constructor
    private StudentOperations() {
    }
 
    public static StudentOperations getInstance() {
        if (instance == null) {
        	// This is a synchronized block, when multiple threads will access this instance
            synchronized (StudentOperations.class) {
                instance = new StudentOperations();
            }
        }
        return instance;
    }


    //function to add Course to a particular student
    @Override
    public void registerCourse(int studentId, int courseId) {
        try {
            studentDAOOperations.registerCourse(studentId, courseId);
            logger.info(UIConstants.SUCCESS_COURSE_REGISTER_MESSAGE);
        } catch (CourseNotAvailableException | CourseNotFoundException | CourseAlreadyRegisteredException | CourseNotRegisteredException | MaximumCourseRegisteredException e) {
            logger.error(e.getMessage());
        }

    }

    //function to drop Course for a particular student
    @Override
    public void dropCourse(int studentId, int courseId) {
        try {
            studentDAOOperations.dropCourse(studentId, courseId);
            logger.info(UIConstants.COURSE_DROP_MESSAGE);
        } catch (CourseNotFoundException | CourseNotRegisteredException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void viewRegisteredCourses(int studentId) {
        ArrayList<Course> courses = studentDAOOperations.viewRegisteredCourses(studentId);
        if (courses.size() == 0) {
            logger.info(UIConstants.NO_COURSE_REGISTERED_MESSAGE);
        } else {
            logger.info("Course Id\tCourse Name");
            courses.forEach(course -> logger.info(course.getCourseId() + "\t\t " + course.getCourseName()));
        }
    }

    public void viewGrades(int studentId) {
        logger.info(UIConstants.DASHED_LINE);
        logger.info("Report Card");
        logger.info(UIConstants.DASHED_LINE);
        List<List> grades = studentDAOOperations.viewGrades(studentId);
        if (grades.size() == 0) {
            logger.info(UIConstants.NO_COURSE_REGISTERED_MESSAGE);
        } else {
            logger.info(String.format("%-15s%-15s%-15s", "Course Id", "Course Name", "Grade"));
            grades.forEach(course -> logger.info(String.format("%-15s%-15s%-15s", course.get(0), course.get(1), course.get(2))));
        }
    }

    @Override
    public int calculateFees(int studentId) {
        int fees = studentDAOOperations.calculateTotalFees(studentId);
        logger.info(UIConstants.PAYABLE_FEE_MESSAGE + fees);
        return fees;
    }

    @Override
    public void makePayment(int studentId, int payModeChoice, int fees) {
        logger.info(studentDAOOperations.makePayment(studentId, payModeChoice, fees).toString());
        notificationOperations.getNotification(studentId);
    }

	@Override
	public void addStudent(Student student, String password) {
		// TODO Auto-generated method stub
		logger.info("in add student");
		int id = studentDAOOperations.addStudent(student, password);
		if(id != -1) {
			logger.info("Your userId is " + id);
		}else {
			logger.info("Registration failed");
		}
		
	}

	@Override
	public boolean isStudentProfileApproved(int studentId) {
		// TODO Auto-generated method stub
		return studentDAOOperations.isStudentProfileApproved(studentId);
	}
}
