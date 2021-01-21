/**
 *
 */
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
    public void addCourse(Student student, int courseId);

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

    public String makePayment(Student student, int paymentMethod, int fees);
}
