package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.dao.CatalogDAOOperations;

import com.flipkart.utils.PrintTabularInterface;
import com.flipkart.utils.StringFormatUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Course Catalog business class
 */
public class CourseCatalogOperations implements CourseCatalogInterface {

    private static Logger logger = Logger.getLogger(CourseCatalogOperations.class);
    private static CatalogDAOOperations catalogDAOOperations = CatalogDAOOperations.getInstance();

    private static volatile CourseCatalogOperations instance = null;

    private CourseCatalogOperations() {
    }

    public static CourseCatalogOperations getInstance() {
        if (instance == null) {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized (CourseCatalogOperations.class) {
                instance = new CourseCatalogOperations();
            }
        }
        return instance;
    }

    private List<String> getAsListCourse(Course course) {
        return new ArrayList<>(Arrays.asList(Integer.toString(course.getCourseId()), course.getCourseName()));
    }

    @Override
    public void viewCoursesCatalog() {
        ArrayList<Course> courses = catalogDAOOperations.viewCoursesCatalog();
        List<String> columnNames = Arrays.asList("Course ID", "Course Name");
        PrintTabularInterface fn = param -> getAsListCourse((Course) param);
        StringFormatUtil.printTabular(logger, columnNames, courses, fn);
    }

    private List<String> getAsListB(Course course) {
        return new ArrayList<>(Arrays.asList(Integer.toString(course.getCourseId()), course.getCourseName(), course.getDescription(), Integer.toString(course.getFees()), Integer.toString(course.getCapacity())));
    }

    @Override
    public void viewCourseDetails(int courseId) {
        Course courses = catalogDAOOperations.viewCourseDetails(courseId);
        List<String> columnNames = Arrays.asList("Course ID", "Course Name", "Description", "Fees", "Capacity");
        PrintTabularInterface fn = param -> getAsListB((Course) param);
        StringFormatUtil.printTabular(logger, columnNames, new ArrayList<>(Arrays.asList(courses)), fn);
    }

    @Override
    public void viewCoursesOffered() {
        ArrayList<Course> course = catalogDAOOperations.viewCoursesOffered();
        List<String> columnNames = Arrays.asList("Course ID", "Course Name");
        PrintTabularInterface fn = param -> getAsListCourse((Course) param);
        StringFormatUtil.printTabular(logger, columnNames, course, fn);
    }
}
