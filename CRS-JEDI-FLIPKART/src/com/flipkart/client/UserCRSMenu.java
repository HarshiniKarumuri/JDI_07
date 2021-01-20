package com.flipkart.client;

import com.flipkart.bean.Professor;
import com.flipkart.business.ProfessorOperations;
import com.flipkart.constants.UIConstants;

import java.util.logging.Logger;

/**
 * User main class (user interface)
 */
public class UserCRSMenu {

	private static final Logger logger = Logger.getLogger(UserCRSMenu.class.getName());

	// To maintain logged in/out state of the user
	static boolean loggedIn;

	/**
	 * CRS start execution method
	 * @param args command line input to program
	 */
	public static void main(String[] args) {
		logger.info(UIConstants.WELCOME_MESSAGE);

		/* //Tester
		loggedIn = true;
		Professor professor = new Professor();
		professor.setProfessorName("Mr. Aman");
		professor.setProfessorId(2223423);
		professor.setUserId(1233334);
		professor.setUsername("aman.rocks");
		professor.setEmail("aman.rocks@crshome.com");

		ProfessorCRSMenu professorCRSMenu = new ProfessorCRSMenu();
		professorCRSMenu.displayMenu(professor);*/
	}

	/**
	 * To logout user from the corresponding profile and redirect to user menu
	 * Flips boolean state of loggedIn variable in UserCRSMenu
	 */
	public static void logout() {
		loggedIn = false;
	}
}
