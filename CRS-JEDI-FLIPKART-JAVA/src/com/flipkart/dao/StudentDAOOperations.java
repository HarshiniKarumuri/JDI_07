package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.constants.UIConstants;
import com.flipkart.exception.*;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOOperations implements StudentDAOInterface {

    private static final Logger logger = Logger.getLogger(StudentDAOOperations.class);
    private final Connection connection = DBUtils.getConnection();
    private final CatalogDAOInterface catalogDAOOperations = CatalogDAOOperations.getInstance();

    private static volatile StudentDAOOperations instance = null;

    // private constructor
    private StudentDAOOperations() {
    }

    public static StudentDAOOperations getInstance() {
        if (instance == null) {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized (StudentDAOOperations.class) {
                instance = new StudentDAOOperations();
            }
        }
        return instance;
    }

    @Override
    public void registerCourse(int studentId, int courseId) throws CourseNotAvailableException, CourseNotFoundException, CourseAlreadyRegisteredException, CourseNotRegisteredException, MaximumCourseRegisteredException {

        PreparedStatement stmt;
        int rows = 0;

        // check if limit to register course reached
        if (numberOfRegisteredCourse(studentId) >= 4) {
            throw new MaximumCourseRegisteredException();
        }
        // check if course capacity exceeds
        else if (checkCourseCapacityExceeds(courseId)) {
            throw new CourseNotAvailableException(courseId);
        }
        // check if course already registered
        else if (checkRegisteredCourses(studentId, courseId)) {
            throw new CourseAlreadyRegisteredException(courseId);
        }
        // check if course is offered
        else if (!catalogDAOOperations.checkCourseOffered(courseId)) {
            throw new CourseNotFoundException(courseId);

        } else {
            try {
                stmt = connection.prepareStatement(SQLQueriesConstants.ADD_COURSE_STUDENT_QUERY);
                stmt.setInt(1, studentId);
                stmt.setInt(2, courseId);
                rows = stmt.executeUpdate();
                stmt.close();

            } catch (Exception se) {
                logger.error(se.getMessage());
            }
        }

        if (rows <= 0) {
            throw new CourseNotRegisteredException(courseId);
        }
    }

    private boolean checkCourseCapacityExceeds(int courseId) {
        PreparedStatement stmt;
        Course course = catalogDAOOperations.viewCourseDetails(courseId);
        int count = 0;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.COUNT_STUDENT_REGISTERED_IN_COURSE);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            stmt.close();
        } catch (Exception se) {
            logger.error(se.getMessage());
        }
        return count >= course.getCapacity();
    }

    private boolean checkRegisteredCourses(int studentId, int courseId) {
        PreparedStatement stmt;
        int count = 0;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.CHECK_IF_REGISTERED_TO_COURSE_QUERY);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            stmt.close();
        } catch (Exception se) {
            logger.error(se.getMessage());
        }
        return count > 0;
    }

    private int numberOfRegisteredCourse(int studentId) {
        int count = 0;
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.COUNT_REGISTERED_COURSES_QUERY);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            stmt.close();
        } catch (Exception se) {
            logger.error(se.getMessage());
        }
        return count;
    }

    @Override
    public void dropCourse(int studentId, int courseId) throws CourseNotFoundException, CourseNotRegisteredException {

        PreparedStatement stmtRequest;
        int rows = 0;

        if (!catalogDAOOperations.checkCourseOffered(courseId)) {
            throw new CourseNotFoundException(courseId);
        }

        try {
            stmtRequest = connection.prepareStatement(SQLQueriesConstants.DROP_COURSE_STUDENT_QUERY);
            stmtRequest.setInt(1, courseId);
            stmtRequest.setInt(2, studentId);
            rows = stmtRequest.executeUpdate();
            stmtRequest.close();

        } catch (Exception se) {
            logger.error(se.getMessage());
        }

        if (rows <= 0) {
            throw new CourseNotRegisteredException(courseId);
        }
    }

    @Override
    public List<List> viewGrades(int studentId) {

        List<List> grades = new ArrayList<>();
        PreparedStatement stmtRequest;
        ResultSet result = null;

        try {
            stmtRequest = connection.prepareStatement(SQLQueriesConstants.VIEW_GRADES_QUERY);
            stmtRequest.setInt(1, studentId);
            result = stmtRequest.executeQuery();
            while (result.next()) {
                Course course = catalogDAOOperations.viewCourseDetails(result.getInt(1));
                ArrayList courseGrade = new ArrayList();
                courseGrade.add(result.getInt(1));
                courseGrade.add(course.getCourseName());
                courseGrade.add(result.getString(2));
                grades.add(courseGrade);
            }
            stmtRequest.close();

        } catch (Exception se) {
            logger.error(se.getMessage());
        }

        return grades;
    }

    public int calculateTotalFees(int studentId) {

        int totalFees = 0;
        PreparedStatement stmtRequest;
        ResultSet result;

        try {
            stmtRequest = connection.prepareStatement(SQLQueriesConstants.CALCULATE_TOTAL_FEE);
            stmtRequest.setInt(1, studentId);
            result = stmtRequest.executeQuery();
            if (result.next()) {
                totalFees = result.getInt(1);
            }
            stmtRequest.close();

        } catch (Exception se) {
            logger.error(se.getMessage());
        }

        return totalFees;
    }

    @Override
    public Payment makePayment(int studentId, int payModeChoice, int fees) {

        PreparedStatement stmtRequest, stmtReConfirm;
        ResultSet result;
        Payment payment = null;

        try {
            stmtRequest = connection.prepareStatement(SQLQueriesConstants.MAKE_PAYMENT_QUERY);
            stmtRequest.setInt(1, studentId);
            stmtRequest.setInt(2, fees);
            stmtRequest.setString(3, UIConstants.PAYMENT_MODE[payModeChoice - 1]);
            stmtRequest.executeUpdate();
            stmtRequest = connection.prepareStatement(SQLQueriesConstants.GET_LATEST_PAYMENT_DETAILS);
            stmtRequest.setInt(1, studentId);
            result = stmtRequest.executeQuery();
            result.next();
            payment = new Payment();
            payment.setPaymentId(result.getInt(1));
            payment.setPaymentTime(result.getTimestamp(4));
            payment.setFeesPaid(result.getInt(3));
            payment.setPaymentMode(result.getString(5));
            /*if(result.next()) {
            	
                /*int pid = result.getInt(1);
                //stmtReConfirm = connection.prepareStatement("select * from Payment where payment_id = "+pid);
                //result = stmtReConfirm.executeQuery();
                if(result.next() && result.getInt(2) == studentId) {
                    
                } else {
                    throw  new PaymentFailedException();
                }
            } else {
                throw new PaymentFailedException();
            }*/

        } catch (Exception se) {
            logger.error(se.getMessage());
        }
        return payment;
    }


    @Override
    public Student getStudentDetails(int userId) {

        PreparedStatement statement;
        Student student = new Student();

        try {
            statement = connection.prepareStatement(SQLQueriesConstants.VIEW_STUDENT_QUERY);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            student.setStudentId(rs.getInt(1));
            student.setBranch(rs.getString(2));
            student.setHasScholarship(rs.getBoolean(3));
            student.setIsApproved(rs.getBoolean(4));
            student.setUsername(rs.getString(5));
            student.setGender(rs.getString(6));
            student.setAddress(rs.getString(7));

        } catch (Exception se) {
            logger.error(se.getMessage());
        }

        return student;
    }

    @Override
    public ArrayList<Course> viewRegisteredCourses(int studentId) {

        ArrayList<Course> courses = new ArrayList<>();
        PreparedStatement stmtRequest;
        ResultSet result;

        try {
            stmtRequest = connection.prepareStatement(SQLQueriesConstants.GET_REGISTERED_COURSES_QUERY);
            stmtRequest.setInt(1, studentId);
            result = stmtRequest.executeQuery();
            while (result.next()) {
                courses.add(catalogDAOOperations.viewCourseDetails(result.getInt(1)));
            }
            stmtRequest.close();

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return courses;
    }

    private boolean checkIsRegisteredUser(String email) {
        PreparedStatement stmtRequest;
        ResultSet result;
        try {
            stmtRequest = connection.prepareStatement(SQLQueriesConstants.CHECK_EMAIL_EXIST_QUERY);
            stmtRequest.setString(1, email);
            result = stmtRequest.executeQuery();
//            if (result.next()) {
//                return true;
//            }
            if (result.getInt(1) != 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public int addStudent(Student student, String password) throws AlreadyRegisteredUserException, RegistrationFailedException {
        PreparedStatement statement;
        ResultSet result;

        if (checkIsRegisteredUser(student.getEmail())) {
            throw new AlreadyRegisteredUserException(student.getEmail());
        }

        try {
            statement = connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
            statement.setString(1, student.getEmail());
            statement.setString(2, student.getPassword());
            statement.setString(3, student.getRole());
            int rows = statement.executeUpdate();
            if (rows <= 0) {
                throw new RegistrationFailedException(student.getEmail());
            }

            statement = connection.prepareStatement(SQLQueriesConstants.FETCH_USER_ID);
            statement.setString(1, student.getEmail());
            result = statement.executeQuery();
            result.next();
            student.setUserId(result.getInt(1));

            statement = connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
            statement.setInt(1, student.getUserId());
            statement.setString(2, student.getBranch());
            statement.setBoolean(3, student.getHasScholarship());
            statement.setBoolean(4, student.getIsApproved());
            statement.setString(5, student.getUsername());
            statement.setString(6, student.getGender());
            statement.setString(7, student.getAddress());
            rows = statement.executeUpdate();

        } catch (RegistrationFailedException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return student.getUserId();
    }

    @Override
    public boolean isStudentProfileApproved(int studentId) {
        PreparedStatement statement = null;
        boolean isApproved = false;
        try {
            statement = connection.prepareStatement(SQLQueriesConstants.IS_STUDENT_APPROVED);
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            isApproved = rs.getBoolean(1);
        } catch (Exception se) {
            logger.error(se.getMessage());
        }
        return isApproved;
    }
}
