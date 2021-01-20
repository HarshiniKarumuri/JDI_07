package com.flipkart.client;

import com.flipkart.bean.Professor;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.LoginDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * User main class (user interface)
 */
public class UserCRSMenu {

	public static Logger logger = Logger.getLogger(UserCRSMenu.class);
	public static Scanner scanner = new Scanner(System.in);
	public static boolean loggedIn;
	
	/**
	 * CRS start execution method
	 * @param args command line input to program
	 */
	public static void main(String[] args) {
		logger.info("Welcome to Course Registration System!!!");
		UserCRSMenu.showMenu();
		logger.info("Thank you for Using CRS");
		scanner.close();
	}
	
	
	//Show Menu to User
	public static void showMenu() {
		boolean showingMenu = true;
		int choice = 0;
		while(showingMenu) {
			
			try {
			logger.info("Enter 1 to login");
			logger.info("Enter 2  to register as a student");
			logger.info("Enter any other number to exit");
			
			choice = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				logger.error(e.getMessage());
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
	
	//To login User
	public static void login() {
		logger.info("Enter Username");
		String username = scanner.nextLine();
		logger.info("Enter Password");
		String password = scanner.nextLine();
		
		loggedIn = true;
		LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
		String role = loginDaoImpl.login(username, password);
		
		switch(role) {
			case "Professor":
				logger.info("User logged in as " + role);
				ProfessorCRSMenu professorCrsMenu = new ProfessorCRSMenu();
				ProfessorDaoImpl professorDaoImpl = new ProfessorDaoImpl();
				Professor professor = professorDaoImpl.getProfessorDetails(username);
				//logger.info(professor.getName());
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
	
	public static void logout() {
		UserCRSMenu.loggedIn = false;
		logger.info("User logged out");
	}

}
