package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

//import com.Student;
import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

/**
 * Student business interface
 */
public interface StudentInterface {

    /**
     * chose a course from course catalog to register
     *
     * @param studentId unique identifier for student
     * @param courseId  unique identifier for course
     */
    void registerCourse(int studentId, int courseId) throws CourseNotFoundException, MaximumCourseRegisteredException, CourseNotAvailableException, CourseAlreadyRegisteredException, CourseNotRegisteredException;

    /**
     * Drop course
     *
     * @param studentId unique identifier for student
     * @param courseId  unique identifier for course
     */
    void dropCourse(int studentId, int courseId) throws CourseNotFoundException, CourseNotRegisteredException;

    /**
     * view chosen courses
     *
     * @param studentId unique identifier for student
     */
    ArrayList<Course> viewRegisteredCourses(int studentId);

    /**
     * view personal grades
     *
     * @param studentId unique identifier for student
     */
    List<List> viewGrades(int studentId);

    /**
     * total fee calculation
     *
     * @param studentId unique identifier for student
     * @return total fee of all courses chosen in a semester
     */
    int calculateFees(int studentId);

    /**
     * make payment of semester courses fee
     *
     * @param studentId     unique identifier for student
     * @param payModeChoice mode of payment
     */
    Payment makePayment(int studentId, int payModeChoice);

    /**
     * Register a new Student
     * @param student  student object
     *
     * @return
     */
    int addStudent(Student student) throws RegistrationFailedException, AlreadyRegisteredUserException;

    /**
     * Approve student profile
     *
     * @param studentId unique identifier for student
     * @return true or false according to student is approves or not
     */
    boolean isStudentProfileApproved(int studentId);
}