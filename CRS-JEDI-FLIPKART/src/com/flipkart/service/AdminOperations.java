package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
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
	private static final CatalogDAOOperations catalogDAOOperations = new CatalogDAOOperations();
	private static final NotificationDAOOperation notificationDAOOperation = NotificationDAOOperation.getInstance();

	private static volatile AdminOperations instance = null;
	 
    // private constructor
    private AdminOperations() {
    }
 
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
		// TODO Auto-generated method stub
		logger.info("In viewUser");
		
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
		// TODO Auto-generated method stub
		logger.info("In add Professor");
		int professorId = adminDAOOperations.addProfessor(professor, password);
		if(professorId != -1)
			logger.info("Your professor Id is" + professorId);
		else
			logger.info("Professor registration failed");
	}
	
	@Override
	public void assignProfessorToCourse(int professorId, int courseId) {
		// TODO Auto-generated method stub
		logger.info("In assign Professor");
		adminDAOOperations.assignProfessorToCourse(professorId, courseId);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		logger.info("In delete User");
		adminDAOOperations.deleteUser(userId);
	}

	@Override
	public void addAdmin(Admin admin, String password) {
		// TODO Auto-generated method stub
		logger.info("In add admin");
		int adminId = adminDAOOperations.addAdmin(admin, password);
		if(adminId != -1)
			logger.info("Your Admin Id is" + adminId);
		else
			logger.info("Admin registration failed");
	}

	@Override
	public void viewCoursesOffered() {
		// TODO Auto-generated method stub
		List<Course> courses;
		courses = catalogDAOOperations.viewCatalog();
		
		logger.info(String.format("%-15s", "Course Names"));
		for(Course course:courses) {
			logger.info(String.format("%-15s", course.getCourseName()));
		}
	}

	@Override
	public void addCatalog(int catlogId, String catalogName) {
		// TODO Auto-generated method stub
		adminDAOOperations.addCatalog(catlogId, catalogName);
	}

	@Override
	public void removeCatalog(int catalogId) {
		// TODO Auto-generated method stub
		adminDAOOperations.removeCatalog(catalogId);
	}

	@Override
	public void addCourseIntoCatalog(Course course, int catalogId) {
		// TODO Auto-generated method stub
		adminDAOOperations.addCourseIntoCatalog(course, catalogId);
	}

	@Override
	public void removeCourseFromCatalog(int courseId) {
		// TODO Auto-generated method stub
		adminDAOOperations.removeCourseFromCatalog(courseId);
	}

	@Override
	public void addCourseToOffer(int courseId, int catalogId) {
		// TODO Auto-generated method stub
		adminDAOOperations.addCourseToOffer(courseId, catalogId);
	}

	@Override
	public void removeOfferedCourse(int courseId, int catalogId) {
		// TODO Auto-generated method stub
		adminDAOOperations.removeOfferedCourse(courseId, catalogId);
	}

	@Override
	public void approveStudent(int studentId) {
		// TODO Auto-generated method stub
		adminDAOOperations.approveStudent(studentId);
		Notification notification = new Notification();
		notification.setUserId(studentId);
		notification.setTimestamp(new Timestamp(System.currentTimeMillis()));
		notification.setDescription(studentId + " profile is approved so kindly verify it.");
		notificationDAOOperation.sendNotification(notification);
	}

}
