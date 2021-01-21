/**
 *
 */
package com.flipkart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.flipkart.bean.Student;
import com.flipkart.bean.Course;
import com.flipkart.service.StudentOperations;
import org.apache.log4j.Logger;

/**
 * @author mayan
 *
 */
public class StudentDAOOperations implements StudentDAOInterface {

    private final StudentDAOInterface studentDao = new StudentDAOOperations();
    private static final Logger logger = Logger.getLogger(StudentOperations.class);

    /**
     * @return
     */
    @Override
    public ArrayList<Course> viewCourseCatalog() {
        return null;
    }

    /**
     *
     * @param student
     * @return
     */
    public ArrayList<Course> viewRegisteredCourses(Student student) {

        // dummy students data
        ArrayList<Course> courses = new ArrayList<Course>();

        Course course1 = new Course();
        course1.setCourseId(101);
        course1.setCourseName("DAA");
        course1.setDescription("Course Description");
        course1.setFees(100);

        Course course2 = new Course();
        course2.setCourseId(102);
        course2.setCourseName("DSA");
        course2.setDescription("Course Description");
        course2.setFees(100);

        courses.add(course1);
        courses.add(course2);
        return courses;
    }

    /**
     *
     * @param student
     * @param courseId
     */
    public void chooseCourse(Student student, int courseId) {
        studentDao.chooseCourse(student, courseId);
    }

    /**
     *
     * @param student
     * @param courseId
     */
    public void dropCourse(Student student, int courseId) {
        studentDao.dropCourse(student, courseId);
    }

    /**
     * @param student
     * @return
     */
    @Override
    public Map<String, String> viewGrades(Student student) {
        Map<String, String> reports = new HashMap<String, String>();
        return reports;
    }

    @Override
    public String makePayment(Student student, int paymentMethod, int fees) {
        return null;
    }
}
