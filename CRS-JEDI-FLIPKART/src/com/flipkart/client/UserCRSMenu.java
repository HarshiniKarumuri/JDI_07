package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.AdminDAOOperations;
import com.flipkart.dao.LoginDAOInterface;
import com.flipkart.dao.LoginDAOOperations;
import com.flipkart.dao.ProfessorDAOOperations;
import com.flipkart.dao.StudentDAOOperations;
import com.flipkart.service.NotificationOperations;
import com.flipkart.service.StudentOperations;

/**
 * User main class (user interface)
 */
public class UserCRSMenu {

	private static final Logger logger = Logger.getLogger(UserCRSMenu.class.getName());
	public static Scanner scanner = new Scanner(System.in);

	// To maintain logged in/out state of the user
	public static boolean loggedIn = false;

	/**
	 * CRS start execution method
	 *
	 * @param args command line input to program
	 */
	public static void main(String[] args) {
		logger.info(UIConstants.WELCOME_MESSAGE);
		UserCRSMenu.showMenu();
		logger.info(UIConstants.EXIT_MESSAGE);
		scanner.close();
	}

	//Show Menu to User
	public static void showMenu() {
		boolean showingMenu = true;
		int choice = 0;
		while(showingMenu) {
			try {
				logger.info("Enter 1 to login");
				logger.info("Enter 2 to register as a student");
				logger.info("Enter any other number to exit");

				choice = Integer.parseInt(scanner.nextLine());

			} catch (Exception e) {
				logger.info(e.getMessage());
			}

			switch(choice) {
				case 1:
					UserCRSMenu.login();
					break;
				case 2:
					addStudent();
					break;
				default:
					showingMenu = false;
			}
		}
	}

	private static void addStudent() {
		// TODO Auto-generated method stub
		Student student = new Student();
		logger.info("Enter email:");
		student.setEmail(scanner.nextLine());
		
		logger.info("Enter password");
		String password = scanner.nextLine();
		
		logger.info("Enter User name");
		student.setUsername(scanner.nextLine());
		
		student.setRole("Student");
		
		logger.info("Enter Gender");
		student.setGender(scanner.nextLine());
		
		logger.info("Enter Address");
		student.setAddress(scanner.nextLine());
		
		student.setIsApproved(false);
		
		logger.info("Enter Branch");
		student.setBranch(scanner.nextLine());
		
		logger.info("Do you have Scholarship? (Choose from true or false)");
		student.setHasScholarship(Boolean.parseBoolean(scanner.nextLine()));
		
		StudentOperations studentOperations = StudentOperations.getInstance();
		studentOperations.addStudent(student, password);
	}

	/**
	 * To login user in CRS
	 */
	public static void login() {
		logger.info("Enter Userid");
		int userid = Integer.parseInt(scanner.nextLine());
		logger.info("Enter Password");
		String password = scanner.nextLine();

		LoginDAOInterface loginDAOOperations = LoginDAOOperations.getInstance();
		loggedIn = loginDAOOperations.checkCredentials(userid, password);
		String role = loginDAOOperations.login(userid, password);

		switch(role) {
			case "Professor":
				logger.info("User logged in as " + role);
				ProfessorCRSMenu professorCrsMenu = new ProfessorCRSMenu();
				ProfessorDAOOperations professorDAOOperations = ProfessorDAOOperations.getInstance();
				Professor professor = professorDAOOperations.getProfessorDetails(userid);
				professorCrsMenu.displayMenu(professor);
				break;

			case "Student":
				logger.info("User logged in as " + role);
				StudentCRSMenu studentCrsMenu = new StudentCRSMenu();
				StudentDAOOperations studentDAOOperations = StudentDAOOperations.getInstance();
				Student student = studentDAOOperations.getStudentDetails(userid);
				studentCrsMenu.displayMenu(student);
				break;

			case "Admin":
				logger.info("User logged in as " + role);
				AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
				AdminDAOOperations adminDAOOperations = AdminDAOOperations.getInstance();
				Admin admin = adminDAOOperations.getAdminDetails(userid);
				//logger.info(admin.getUsername());
				adminCRSMenu.displayMenu(admin);
				break;
				
			default:
				logger.info("Please Enter correct login credentials");
				UserCRSMenu.showMenu();
		}
	}

	/**
	 * To logout user from the corresponding profile and redirect to user menu
	 * Flips boolean state of loggedIn variable in UserCRSMenu
	 */
	public static void logout() {
		loggedIn = false;
		logger.info(UIConstants.SUCCESSFUL_LOGOUT_MESSAGE);
		logger.info("\n");
	}
}
