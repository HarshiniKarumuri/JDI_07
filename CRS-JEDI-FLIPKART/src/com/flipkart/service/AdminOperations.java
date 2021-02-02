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
import java.util.List;

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
	
	@Override
	public void viewUser() {
		ArrayList<User> users = adminDAOOperations.viewUser();
		
		logger.info("Admin");
		for(User user:users) {
			if(user.getRole().equals("Admin")) {
				logger.info(String.format("UserEmail = %s, UserId = %d", user.getEmail(),user.getUserId()));
			}
		}
		
		logger.info("Student");
		for(User user:users) {
			if(user.getRole().equals("Student")) {
				logger.info(String.format("UserEmail = %s, UserId = %d", user.getEmail(),user.getUserId()));
			}
		}
		
		logger.info("Professor");
		for(User user:users) {
			if(user.getRole().equals("Professor")) {
				logger.info(String.format("UserEmail = %s, UserId = %d", user.getEmail(),user.getUserId()));
			}
		}
	}
	
	@Override
	public void addProfessor(Professor professor,String password) {
//		logger.info("In add Professor");
		int professorId = adminDAOOperations.addProfessor(professor, password);
		if(professorId != -1) {
			logger.info("Your professor Id is" + professorId);
			NotificationOperations notificationOperations = NotificationOperations.getInstance();
			Notification notification = new Notification();
			notification.setDescription("You are Succesfully registered in system");
			notification.setUserId(professor.getProfessorId());
			notificationOperations.sendNotification(notification);
			notificationOperations.getNotification(professor.getProfessorId());
		}
		else {
			logger.info("Professor registration failed");
		}
	}
	
	@Override
	public void assignProfessorToCourse(int professorId, int courseId) {
//		logger.info("In assign Professor");
		adminDAOOperations.assignProfessorToCourse(professorId, courseId);
	}


    @Override
    public void deleteUser(int userId) {
//        logger.info("In delete User");
        adminDAOOperations.deleteUser(userId);
    }

	@Override
	public void addAdmin(Admin admin, String password) {
		logger.info("In add admin");
		int adminId = adminDAOOperations.addAdmin(admin, password);
		if(adminId != -1) {
			logger.info("Your Admin Id is" + adminId);
			NotificationOperations notificationOperations = NotificationOperations.getInstance();
			Notification notification = new Notification();
			notification.setDescription("You are Succesfully registered in system");
			notification.setUserId(admin.getAdminId());
			notificationOperations.sendNotification(notification);
			notificationOperations.getNotification(admin.getAdminId());
		}
		else {
			logger.info("Admin registration failed");
		}
	}


    @Override
    public void viewCoursesOffered() {
        List<Course> courses;
        courses = catalogDAOOperations.viewCoursesCatalog();

        logger.info(String.format("%-15s", "Course Names"));
        for (Course course : courses) {
            logger.info(String.format("%-15s", course.getCourseName()));
        }
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
		adminDAOOperations.approveStudent(studentId);
		Notification notification = new Notification();
		notification.setUserId(studentId);
		notification.setTimestamp(new Timestamp(System.currentTimeMillis()));
		notification.setDescription(studentId + " profile is approved so kindly verify it.");
		notificationDAOOperation.sendNotification(notification);
	}

	@Override
	public void viewPendingApprovalStudent() {
		ArrayList<Student> list = adminDAOOperations.viewPendingApprovalStudent();
		logger.info(UIConstants.DASHED_LINE);
		logger.info(String.format("%-30s%-30s","StudentId", "StudentName"));
		logger.info(UIConstants.DASHED_LINE);
		for(Student student:list) {
			logger.info(String.format("%-30s%-30s", student.getStudentId(), student.getUsername()));
		}
		logger.info("\n");
	}

}