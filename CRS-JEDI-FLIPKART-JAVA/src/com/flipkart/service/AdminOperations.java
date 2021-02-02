package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.AdminDAOOperations;
import com.flipkart.dao.CatalogDAOOperations;
import com.flipkart.dao.NotificationDAOOperation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flipkart.exception.AlreadyRegisteredUserException;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.PrintTabularInterface;
import com.flipkart.utils.StringFormatUtil;
import org.apache.log4j.Logger;

/**
 * Admin business class
 */
public class AdminOperations implements AdminInterface {

    private static Logger logger = Logger.getLogger(AdminOperations.class);
    private static final AdminDAOOperations adminDAOOperations = AdminDAOOperations.getInstance();
    private static final CatalogDAOOperations catalogDAOOperations = CatalogDAOOperations.getInstance();
    private static final NotificationDAOOperation notificationDAOOperation = NotificationDAOOperation.getInstance();

    private static volatile AdminOperations instance = null;

    // private constructor
    private AdminOperations() {
    }

    /**
     * @return instance of AdminOperation
     */
    public static AdminOperations getInstance() {
        if (instance == null) {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized (AdminOperations.class) {
                instance = new AdminOperations();
            }
        }
        return instance;
    }

    private List<String> getAsListUser(User user) {
        return new ArrayList<>(Arrays.asList(user.getEmail(), Integer.toString(user.getUserId())));
    }

    @Override
    public void viewUser() {
        ArrayList<User> users = adminDAOOperations.viewUser();
        ArrayList<User> filterUser = new ArrayList<>();

        logger.info(UIConstants.DASHED_LINE);
        logger.info("Admin");
        logger.info(UIConstants.DASHED_LINE);
        for (User user : users) {
            if (user.getRole().equals("Admin")) {
                filterUser.add(user);
            }
            List<String> columnNames = Arrays.asList("User Email", "User ID");
            PrintTabularInterface fn = param -> getAsListUser((User) param);
            StringFormatUtil.printTabular(logger, columnNames, filterUser, fn);
        }

        logger.info(UIConstants.DASHED_LINE);
        logger.info("Student");
        logger.info(UIConstants.DASHED_LINE);
        filterUser.clear();
        for (User user : users) {
            if (user.getRole().equals("Student")) {
                filterUser.add(user);
            }
            List<String> columnNames = Arrays.asList("User Email", "User ID");
            PrintTabularInterface fn = param -> getAsListUser((User) param);
            StringFormatUtil.printTabular(logger, columnNames, filterUser, fn);
        }

        logger.info(UIConstants.DASHED_LINE);
        logger.info("Professor");
        logger.info(UIConstants.DASHED_LINE);
        filterUser.clear();
        for (User user : users) {
            if (user.getRole().equals("Professor")) {
                filterUser.add(user);
            }
            List<String> columnNames = Arrays.asList("User Email", "User ID");
            PrintTabularInterface fn = param -> getAsListUser((User) param);
            StringFormatUtil.printTabular(logger, columnNames, filterUser, fn);
        }
    }

    @Override
    public void addProfessor(Professor professor) {
        int userId;

        try {
            userId = adminDAOOperations.addProfessor(professor);
            logger.info(UIConstants.SUCCESS_USER_ID_MESSAGE + userId + "\n");
        } catch (AlreadyRegisteredUserException | RegistrationFailedException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void assignProfessorToCourse(int professorId, int courseId) {
        adminDAOOperations.assignProfessorToCourse(professorId, courseId);
    }

    @Override
    public void deleteUser(int userId) {
        try {
            adminDAOOperations.deleteUser(userId);
        } catch (UserNotFoundException e) {
            logger.info(e.getMessage());
        }
    }

    @Override
    public void addAdmin(Admin admin) {
        int userId;

        try {
            userId = adminDAOOperations.addAdmin(admin);
            logger.info(UIConstants.SUCCESS_USER_ID_MESSAGE + userId + "\n");
        } catch (AlreadyRegisteredUserException | RegistrationFailedException e) {
            logger.error(e.getMessage());
        }
    }

    private List<String> getAsListCourse(Course course) {
        return new ArrayList<>(Arrays.asList(course.getCourseName()));
    }

    @Override
    public void viewCoursesOffered() {
        List<Course> courses = catalogDAOOperations.viewCoursesCatalog();
        List<String> columnNames = Arrays.asList("Course Names");
        PrintTabularInterface fn = param -> getAsListCourse((Course) param);
        StringFormatUtil.printTabular(logger, columnNames, courses, fn);
    }

    @Override
    public void addCatalog(int catalogId, String catalogName) {
        adminDAOOperations.addCatalog(catalogId, catalogName);
    }

    @Override
    public void removeCatalog(int catalogId) {
        adminDAOOperations.removeCatalog(catalogId);
    }

    @Override
    public void addCourseIntoCatalog(Course course, int catalogId) {
        adminDAOOperations.addCourseIntoCatalog(course, catalogId);
    }

    @Override
    public void removeCourseFromCatalog(int courseId) {
        adminDAOOperations.removeCourseFromCatalog(courseId);
    }

    @Override
    public void addCourseToOffer(int courseId, int catalogId) {
        adminDAOOperations.addCourseToOffer(courseId, catalogId);
    }

    @Override
    public void removeOfferedCourse(int courseId, int catalogId) {
        adminDAOOperations.removeOfferedCourse(courseId, catalogId);
    }

    @Override
    public void approveStudent(int studentId) {

        try {
            adminDAOOperations.approveStudent(studentId);
        } catch (UserNotFoundException e) {
            logger.info(e.getMessage());
            return;
        }

        Notification notification = new Notification();
        notification.setUserId(studentId);
        notification.setTimestamp(new Timestamp(System.currentTimeMillis()));
        notification.setDescription(studentId + " profile is approved so kindly verify it.");
        notificationDAOOperation.sendNotification(notification);
    }

    private List<String> getAsListStudent(Student student) {
        return new ArrayList<>(Arrays.asList(Integer.toString(student.getStudentId()), student.getUsername()));
    }

    @Override
    public void viewPendingApprovalStudent() {
        ArrayList<Student> students = adminDAOOperations.viewPendingApprovalStudent();
        List<String> columnNames = Arrays.asList("Student ID", "Student Name");
        PrintTabularInterface fn = param -> getAsListStudent((Student) param);
        StringFormatUtil.printTabular(logger, columnNames, students, fn);
    }

}