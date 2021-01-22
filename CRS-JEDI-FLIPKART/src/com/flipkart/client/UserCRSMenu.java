package com.flipkart.client;

import com.flipkart.bean.Professor;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.LoginDAOInterface;
import com.flipkart.dao.LoginDAOOperations;
import com.flipkart.dao.ProfessorDAOOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

/**
 * User main class (user interface)
 */
public class UserCRSMenu {

	private static final Logger logger = Logger.getLogger(UserCRSMenu.class);
	static Scanner scanner = new Scanner(System.in);

	// To maintain logged in/out state of the user
	public static boolean loggedIn;

	// CRS start execution method
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
					break;
				default:
					showingMenu = false;
			}
		}
	}

	// To login user in CRS
	public static void login() {

		String username, password, role;

		logger.info(UIConstants.REQUEST_USERNAME_MESSAGE);
		username = scanner.nextLine();
		logger.info(UIConstants.REQUEST_PASSWORD_MESSAGE) ;
		password = scanner.nextLine();

		loggedIn = true;
		LoginDAOInterface loginDAOOperations = new LoginDAOOperations();
		role = loginDAOOperations.login(username, password);

		switch(role) {
			case "Professor":
				logger.info("User logged in as " + role);
				ProfessorCRSMenu professorCrsMenu = new ProfessorCRSMenu();
				ProfessorDAOOperations professorDAOOperations = new ProfessorDAOOperations();
				Professor professor = professorDAOOperations.getProfessorDetails(username);
				professorCrsMenu.displayMenu(professor);
				break;

			case "Student":
				logger.info("User logged in as " + role);
				break;

			case "Admin":
				logger.info("User logged in as " + role);
				break;
				
			default:
				logger.info("Please Enter correct login credentials");
				UserCRSMenu.showMenu();
		}
	}

	/*
	* To logout user from the corresponding profile and redirect to user menu
	* Flips boolean state of loggedIn variable in UserCRSMenu
	*/
	public static void logout() {
		loggedIn = false;
		logger.info(UIConstants.SUCCESSFUL_LOGOUT_MESSAGE);
		logger.info("\n");
	}
}
