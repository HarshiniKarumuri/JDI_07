package com.flipkart.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flipkart.exception.*;
import com.flipkart.utils.PrintTabularInterface;
import com.flipkart.utils.StringFormatUtil;
import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.StudentDAOInterface;
import com.flipkart.dao.StudentDAOOperations;

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
    public void registerCourse(int studentId, int courseId) throws CourseNotFoundException, MaximumCourseRegisteredException, CourseNotAvailableException, CourseAlreadyRegisteredException, CourseNotRegisteredException {
        try {
            studentDAOOperations.registerCourse(studentId, courseId);
            logger.info(UIConstants.SUCCESS_COURSE_REGISTER_MESSAGE);
        } catch (CourseNotAvailableException | CourseNotFoundException | CourseAlreadyRegisteredException | CourseNotRegisteredException | MaximumCourseRegisteredException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    // DELETE
    //function to drop Course for a particular student
    @Override
    public void dropCourse(int studentId, int courseId) throws CourseNotFoundException, CourseNotRegisteredException {
        try {
            logger.info(UIConstants.COURSE_DROP_MESSAGE);
            studentDAOOperations.dropCourse(studentId, courseId);
        } catch (CourseNotFoundException | CourseNotRegisteredException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    private List<String> getAsList(Course course) {
        return new ArrayList<>(Arrays.asList(Integer.toString(course.getCourseId()), course.getCourseName(), course.getDescription()));
    }

    @Override
    public ArrayList<Course> viewRegisteredCourses(int studentId) {
        ArrayList<Course> courses = studentDAOOperations.viewRegisteredCourses(studentId);
        if (courses.size() == 0) {
            logger.info(UIConstants.NO_COURSE_REGISTERED_MESSAGE);
        } else {
            List<String> columnNames = Arrays.asList("Course ID", "Course Name", "Course Description");
            PrintTabularInterface fn = param -> getAsList((Course) param);
            StringFormatUtil.printTabular(logger, columnNames, courses, fn);
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
            List<String> columnNames = Arrays.asList("Course Id", "Course Name", "Grade");
            PrintTabularInterface fn = (param) -> (List<String>) param;
            StringFormatUtil.printTabular(logger, columnNames, grades, fn);
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
        logger.info(UIConstants.PAYMENT_SUCCESSFUL_MESSAGE);
        logger.info(payment.toString());

        Notification notification = new Notification();
        notification.setDescription("You paid " + payment.getFeesPaid() + "/-");
        notification.setUserId(studentId);
        notificationOperations.sendNotification(notification);
        notificationOperations.getNotification(studentId);

        return payment;
    }

    // POST
    @Override
    public int addStudent(Student student) throws RegistrationFailedException, AlreadyRegisteredUserException {
        int userId;

        try {
            userId = studentDAOOperations.addStudent(student);
            logger.info(UIConstants.SUCCESS_USER_ID_MESSAGE + userId + "\n");

            NotificationOperations notificationOperations = NotificationOperations.getInstance();
            Notification notification = new Notification();
            notification.setDescription("You are Successfully registered in system");
            notification.setUserId(student.getUserId());
            notificationOperations.sendNotification(notification);
            notificationOperations.getNotification(student.getUserId());

        } catch (AlreadyRegisteredUserException | RegistrationFailedException e) {
            logger.error(e.getMessage());
            throw e;
        }

        return userId;
    }

    // GET
    @Override
    public boolean isStudentProfileApproved(int studentId) {
        return studentDAOOperations.isStudentProfileApproved(studentId);
    }
}