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
     * @param studentId
     * @param courseId
     */
    void registerCourse(int studentId, int courseId) throws CourseNotAvailableException, CourseNotFoundException, CourseAlreadyRegisteredException, CourseNotRegisteredException, MaximumCourseRegisteredException;

    /**
     * @param studentId
     * @param courseId
     */
    void dropCourse(int studentId, int courseId) throws CourseNotFoundException, CourseNotRegisteredException;

    /**
     * @param studentId
     * @return
     */
    List<List> viewGrades(int studentId);

    /**
     * @param studentId
     * @return
     */
    int calculateTotalFees(int studentId);

    /**
     * @param studentId
     * @param payModeChoice
     * @param fees
     * @return
     */
    Payment makePayment(int studentId, int payModeChoice, int fees);

    /**
     * Fetches the student details based on username
     *
     * @param userId unique identifier for user
     * @return
     */
    Student getStudentDetails(int userId);
    
    /**
     * @param studentId
     * @return
     */
    ArrayList<Course> viewRegisteredCourses(int studentId);
    
    int addStudent(Student student,String password);
    
    boolean isStudentProfileApproved(int studentId);
}
