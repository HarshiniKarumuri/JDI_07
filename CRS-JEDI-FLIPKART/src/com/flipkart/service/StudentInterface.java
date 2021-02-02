package com.flipkart.service;

import com.flipkart.bean.Student;

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
    void registerCourse(int studentId, int courseId);

    /**
     * Drop course
     *
     * @param studentId unique identifier for student
     * @param courseId  unique identifier for course
     */
    void dropCourse(int studentId, int courseId);

    /**
     * view chosen courses
     *
     * @param studentId unique identifier for student
     */
    void viewRegisteredCourses(int studentId);

    /**
     * view personal grades
     *
     * @param studentId unique identifier for student
     */
    void viewGrades(int studentId);

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
     * @param fees          total fee to pay
     */
    void makePayment(int studentId, int payModeChoice, int fees);

    /**
     * Register a new Student
     *
     * @param student  student object
     * @param password student password
     */
    void registerStudent(Student student, String password);

    /**
     * Approve student profile
     *
     * @param studentId unique identifier for student
     * @return true or false according to student is approves or not
     */
    boolean isStudentProfileApproved(int studentId);
}
