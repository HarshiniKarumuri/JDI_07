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
	public ArrayList<User> viewUser() {
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

		return users;
	}
	
	@Override
	public int addProfessor(Professor professor) {
		int userId = -1;

		try {
			userId = adminDAOOperations.addProfessor(professor);
			logger.info(UIConstants.SUCCESS_USER_ID_MESSAGE + userId + "\n");
		} catch (AlreadyRegisteredUserException | RegistrationFailedException e) {
			logger.error(e.getMessage());
		}

		return userId;
	}
	
	@Override
	public void assignProfessorToCourse(int professorId, int courseId) {
		adminDAOOperations.assignProfessorToCourse(professorId, courseId);
	}


    @Override
    public void deleteUser(int userId) throws UserNotFoundException {
		try {
			adminDAOOperations.deleteUser(userId);
		} catch (UserNotFoundException e) {
			logger.info(e.getMessage());
			throw e;
		}
    }

	@Override
	public int addAdmin(Admin admin) {
		int userId = -1;

		try {
			userId = adminDAOOperations.addAdmin(admin);
			logger.info(UIConstants.SUCCESS_USER_ID_MESSAGE + userId + "\n");
		} catch (AlreadyRegisteredUserException | RegistrationFailedException e) {
			logger.error(e.getMessage());
		}

		return userId;
	}

	private List<String> getAsListCourse(Course course) {
		return new ArrayList<>(Arrays.asList(course.getCourseName()));
	}

    @Override
    public List<Course> viewCoursesOffered() {
		List<Course> courses = catalogDAOOperations.viewCoursesCatalog();
		List<String> columnNames = Arrays.asList("Course Names");
		PrintTabularInterface fn = param -> getAsListCourse((Course) param);
		StringFormatUtil.printTabular(logger, columnNames, courses, fn);
        return courses;
    }

    @Override
    public int addCatalog(int catalogId, String catalogName) {
        return adminDAOOperations.addCatalog(catalogId, catalogName);
    }

    @Override
    public void removeCatalog(int catalogId) {
        adminDAOOperations.removeCatalog(catalogId);
    }

    @Override
    public int addCourseIntoCatalog(Course course, int catalogId) {
       int catalogid= adminDAOOperations.addCourseIntoCatalog(course, catalogId);
       return catalogid;
    }

    @Override
    public void removeCourseFromCatalog(int courseId) {
        adminDAOOperations.removeCourseFromCatalog(courseId);
    }

    @Override
    public int addCourseToOffer(int courseId, int catalogId) {
        int courseid=adminDAOOperations.addCourseToOffer(courseId, catalogId);
        return courseid;
    }

    @Override
    public void removeOfferedCourse(int courseId, int catalogId) {
        adminDAOOperations.removeOfferedCourse(courseId, catalogId);
    }

	@Override
	public void approveStudent(int studentId) throws UserNotFoundException {
		try {
			adminDAOOperations.approveStudent(studentId);

			Notification notification = new Notification();
			notification.setUserId(studentId);
			notification.setTimestamp(new Timestamp(System.currentTimeMillis()));
			notification.setDescription(studentId + " profile is approved so kindly verify it.");
			notificationDAOOperation.sendNotification(notification);

		} catch (UserNotFoundException e) {
			logger.info(e.getMessage());
			throw e;
		}
	}

	private List<String> getAsListStudent(Student student) {
		return new ArrayList<>(Arrays.asList(Integer.toString(student.getStudentId()), student.getUsername()));
	}

	@Override
	public List<Student> viewPendingApprovalStudent() {
		ArrayList<Student> students = adminDAOOperations.viewPendingApprovalStudent();
		List<String> columnNames = Arrays.asList("Student ID", "Student Name");
		PrintTabularInterface fn = param -> getAsListStudent((Student) param);
		StringFormatUtil.printTabular(logger, columnNames, students, fn);

		return students;
	}

}