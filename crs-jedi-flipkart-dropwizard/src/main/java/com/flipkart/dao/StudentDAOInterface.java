package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public interface StudentDAOInterface {

    /**
     * for the student to register for a course
     * @param studentId
     * @param courseId
     */
    void registerCourse(int studentId, int courseId) throws CourseNotAvailableException, CourseNotFoundException, CourseAlreadyRegisteredException, CourseNotRegisteredException, MaximumCourseRegisteredException;

    /**
     * for the student to drop a course
     * @param studentId
     * @param courseId
     */
    void dropCourse(int studentId, int courseId) throws CourseNotFoundException, CourseNotRegisteredException;

    /**
     * to view all the grades for a particular student
     * @param studentId
     * @return
     */
    List<List> viewGrades(int studentId);

    /**
     * Calculate the total fees
     * @param studentId
     * @return
     */
    int calculateTotalFees(int studentId);

    /**
     * @param studentId
     * @param payModeChoice
     * @param fees
     * @return the amount which has been paid
     */
    Payment makePayment(int studentId, int payModeChoice, int fees);

    /**
     * Fetches the student details based on username
     *
     * @param userId unique identifier for user
     * @return the details of the student
     */
    Student getStudentDetails(int userId);
    
    /**
     * view all the courses registered by a student
     * @param studentId
     * @return the list of all the registered courses
     */
    ArrayList<Course> viewRegisteredCourses(int studentId);
    /**
     * 
     * @param student
     * @param password
     * @return the userid of the student
     */
    int addStudent(Student student,String password);
    /**
     * @param studentId
     * @return the status of the approval of the student profile
     */
    boolean isStudentProfileApproved(int studentId);
}
