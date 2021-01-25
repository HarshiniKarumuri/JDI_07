package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.dao.CatalogDAOOperations;

import org.apache.log4j.Logger;

import java.util.ArrayList;

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

    @Override
    public void viewCoursesCatalog() {
        // TODO Auto-generated method stub
        logger.info("In fetch Catalog Details");
        ArrayList<Course> list = new ArrayList<Course>();
        list = catalogDAOOperations.viewCoursesCatalog();
        logger.info("CourseID  CourseName");
        for (Course course : list) {
            logger.info(course.getCourseId() + " " + course.getCourseName());
        }
    }

    @Override
    public void viewCourseDetails(int courseId) {
        // TODO Auto-generated method stub
        logger.info("In view Course Details");
        Course course = new Course();
        course = catalogDAOOperations.viewCourseDetails(courseId);
        logger.info("CourseID  CourseName Description Fees Capacity");
        logger.info(course.getCourseId() + " " + course.getCourseName() + " " + course.getDescription() + " " + course.getFees() + " " + course.getCapacity());

    }

    @Override
    public void viewCoursesOffered() {
        logger.info("In view Courses Offered");
        ArrayList<Course> list = new ArrayList<Course>();
        list = catalogDAOOperations.viewCoursesOffered();
        logger.info("CourseID  CourseName");
        for (Course course : list) {
            logger.info(course.getCourseId() + " " + course.getCourseName());
        }
    }
}
