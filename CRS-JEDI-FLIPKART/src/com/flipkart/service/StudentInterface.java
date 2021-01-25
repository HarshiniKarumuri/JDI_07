package com.flipkart.service;

import com.flipkart.bean.Student;

/**
 * Student business interface
 */
public interface StudentInterface {

    void registerCourse(int studentId, int courseId);

    void dropCourse(int studentId, int courseId);

    void viewRegisteredCourses(int studentId);

    void viewGrades(int studentId);

    int calculateFees(int studentId);

    void makePayment(int studentId, int payModeChoice, int fees);
    
    void addStudent(Student student,String password);
    
    boolean isStudentProfileApproved(int studentId);
}
