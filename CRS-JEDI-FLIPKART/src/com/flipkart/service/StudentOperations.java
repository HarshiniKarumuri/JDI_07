package com.flipkart.service;

import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.StudentDAOInterface;
import com.flipkart.dao.StudentDAOOperations;

/**
 * Student business class
 */
public class StudentOperations implements StudentInterface {

    private static final Logger logger = Logger.getLogger(StudentOperations.class);

    StudentDAOInterface studentDao = new StudentDAOOperations();

    /**
     *
     */
    @Override
    public void viewCourseCatalog() {
        ArrayList<Course> courses = studentDao.viewCourseCatalog();
        logger.info("Course Id\tCourse Name");
        courses.forEach(course -> logger.info(course.getCourseId() + "\t\t " + course.getCourseName()));
    }

    //function to add Course to a particular student

    /**
     * @param student
     * @param courseId
     */
    @Override
    public void chooseCourse(Student student, int courseId) {

        //TODO:  Exception handling
        studentDao.chooseCourse(student, courseId);
    }

    /**
     * @param student
     * @param courseId
     */
    //function to drop Course for a particular student
    @Override
    public void dropCourse(Student student, int courseId) {

        //TODO:  Exception handling
        studentDao.dropCourse(student, courseId);
        logger.info(UIConstants.COURSE_DROP_MESSAGE);
    }

    /**
     * @param student
     */
    @Override
    public void viewRegisteredCourse(Student student) {
        ArrayList<Course> courses = studentDao.viewRegisteredCourses(student);
        if (courses.size() == 0) {
            logger.info(UIConstants.NO_COURSE_REGISTERED_MESSAGE);
        } else {
            logger.info("Course Id\tCourse Name");
            courses.forEach(course -> logger.info(course.getCourseId() + "\t\t " + course.getCourseName()));
        }
    }

    /**
     * @param student
     */
    @Override
    public void viewGrades(Student student) {
        studentDao.viewGrades(student).forEach((k, v) -> logger.info(k + "\t" + v));
    }

    @Override
    public void makePayment(Student student, int paymentMethod, int fees) {
        logger.info(studentDao.makePayment(student, paymentMethod, fees));
    }
}
