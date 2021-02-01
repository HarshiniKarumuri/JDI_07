package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.StudentDAOInterface;
import com.flipkart.dao.StudentDAOOperations;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.CourseNotRegisteredException;
import com.flipkart.exception.MaximumCourseRegisteredException;

/**
 * Student service class
 */
public class StudentOperations implements StudentInterface {

    private static final Logger logger = Logger.getLogger(StudentOperations.class);

    private final StudentDAOInterface studentDAOOperations = StudentDAOOperations.getInstance();
    private final NotificationOperations notificationOperations = NotificationOperations.getInstance();

//    StudentDao studentDao = new StudentDaoImpl();

    private static volatile StudentOperations instance = null;

    // private constructor
    private StudentOperations() {
    }

    public static StudentOperations getInstance() {
        if (instance == null) {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized (StudentOperations.class) {
                instance = new StudentOperations();
            }
        }
        return instance;
    }

    // POST
    //function to add Course to a particular student
    @Override
    public void registerCourse(int studentId, int courseId) {
        try {
            studentDAOOperations.registerCourse(studentId, courseId);
            logger.info(UIConstants.SUCCESS_COURSE_REGISTER_MESSAGE);
        } catch (CourseNotAvailableException | CourseNotFoundException | CourseAlreadyRegisteredException | CourseNotRegisteredException | MaximumCourseRegisteredException e) {
            logger.error(e.getMessage());
        }

    }

    // DELETE
    //function to drop Course for a particular student
    @Override
    public boolean dropCourse(int studentId, int courseId) {
        try {
            logger.info(UIConstants.COURSE_DROP_MESSAGE);
            studentDAOOperations.dropCourse(studentId, courseId);
            return true;
        } catch (CourseNotFoundException | CourseNotRegisteredException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Course> viewRegisteredCourses(int studentId) {
        ArrayList<Course> courses = studentDAOOperations.viewRegisteredCourses(studentId);
//        logger.info("LOl");
        if (courses.size() == 0) {
            logger.info(UIConstants.NO_COURSE_REGISTERED_MESSAGE);
        } else {
            //logger.info("Course Id\tCourse Name");
            courses.forEach(course -> logger.info(course.getCourseId() + "\t\t " + course.getCourseName()));
        }
        return courses;
    }

    public List<List> viewGrades(int studentId) {
        logger.info(UIConstants.DASHED_LINE);
        logger.info("Report Card");
        logger.info(UIConstants.DASHED_LINE);
        List<List> grades = studentDAOOperations.viewGrades(studentId);
        if (grades.size() == 0) {
            logger.info(UIConstants.NO_COURSE_REGISTERED_MESSAGE);
        } else {
            logger.info(String.format("%-15s%-15s%-15s", "Course Id", "Course Name", "Grade"));
            grades.forEach(course -> logger.info(String.format("%-15s%-15s%-15s", course.get(0), course.get(1), course.get(2))));
        }
        return grades;
    }

    @Override
    public int calculateFees(int studentId) {
        int fees = studentDAOOperations.calculateTotalFees(studentId);
        logger.info(UIConstants.PAYABLE_FEE_MESSAGE + fees);
        return fees;
    }

    // POST
    @Override
    public Payment makePayment(int studentId, int payModeChoice) {
        int fees = calculateFees(studentId);
        Payment payment = studentDAOOperations.makePayment(studentId, payModeChoice, fees);
       //logger.info(payment.toString());
        Notification notification = new Notification();
        notification.setDescription("You paid " + payment.getFeesPaid() + "/-");
        notification.setUserId(studentId);
        notificationOperations.sendNotification(notification);
        notificationOperations.getNotification(studentId);
        return payment;
    }

    // POST
    @Override
    public void addStudent(Student student, String password) {
        logger.info("in add student");
        int id = studentDAOOperations.addStudent(student, password);
        if(id != -1) {
            logger.info("Your userId is " + id);
            NotificationOperations notificationOperations = NotificationOperations.getInstance();
            Notification notification = new Notification();
            notification.setDescription("You are Successfully registered in system");
            notification.setUserId(student.getStudentId());
            notificationOperations.sendNotification(notification);
            notificationOperations.getNotification(student.getStudentId());
        }else {
            logger.info("Registration failed");
        }

    }

    // GET
    @Override
    public boolean isStudentProfileApproved(int studentId) {
        return studentDAOOperations.isStudentProfileApproved(studentId);
    }
}