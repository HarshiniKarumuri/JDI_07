package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * @author mayan
 *
 */
public interface StudentDAOInterface {

    /**
     *
     * @return
     */
    public ArrayList<Course> viewCourseCatalog();
    /**
     *
     * @param student
     * @return
     */
    public ArrayList<Course> viewRegisteredCourses(Student student);

    /**
     *
     * @param student
     * @param courseId
     */
    public void chooseCourse(Student student, int courseId);

    /**
     *
     * @param student
     * @param courseId
     */
    public void dropCourse(Student student, int courseId);

    /**
     * @param student
     * @return
     */
    public Map<String, String> viewGrades(Student student);
    
    /**
     * @param student
     * @return
     */
    public int calculateTotalFees(Student student);

    /**
     * @param student
     * @param paymentMethod
     * @param fees
     * @return
     */
    public String makePayment(Student student, int paymentMethod, int fees);
    
    /**
     * Fetches the student details based on username
     * 
     * @param username unique identifier for user
     * @return
     */
    public Student getStudentDetails(String username);
}
