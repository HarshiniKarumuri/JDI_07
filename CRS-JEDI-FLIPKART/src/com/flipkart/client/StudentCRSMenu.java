package com.flipkart.client;

import java.util.Scanner;
import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.service.StudentOperations;

/**
 * Student main class (user interface)
 */
public class StudentCRSMenu {
	private static Logger logger = Logger.getLogger(StudentCRSMenu.class.getName());
	StudentOperations studentOperations = new StudentOperations();
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu(Student student) {
		// input variables
		int courseId, choice;
		
		// check if user is logged in
		while(UserCRSMenu.loggedIn) {

			// Options available for student
			logger.info(UIConstants.ENTER_CHOICES_MESSAGE);
			logger.info("0. To logout and return to main menu");
			logger.info("1. View available courses");
			logger.info("2. Add a course");
			logger.info("3. Drop a course");
			logger.info("4. View registered courses");
			logger.info("5. Pay fees");
			logger.info("6. View grades");
			logger.info(UIConstants.DASHED_LINE);
			choice = sc.nextInt();
			sc.nextLine();
			logger.info("\n");
			
			//switch to the selected choice
			switch(choice) 
			{
				case 1: studentOperations.viewCourseCatalog();
						break;
				
				case 2: logger.info(UIConstants.VIEW_COURSES_MESSAGE);
						studentOperations.viewCourseCatalog();
						logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
						courseId = sc.nextInt();
						studentOperations.chooseCourse(student, courseId);
						break;
				
				case 3: logger.info(UIConstants.VIEW_REG_COURSES_MESSAGE);
						studentOperations.viewRegisteredCourse(student);
						logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
						courseId = sc.nextInt();
						studentOperations.dropCourse(student, courseId);
						break;
						
				case 4: studentOperations.viewRegisteredCourse(student);
						break;
						
				case 5: logger.info(UIConstants.SELECT_CORRECT_OPTION_MESSAGE);
						logger.info("1. Cash \n 2. Card \n 3. Net Banking \n");
						choice = sc.nextInt();
						int fees = studentOperations.calculateFees(student);
						studentOperations.makePayment(student, choice, fees);
						break;
				
				case 6: studentOperations.viewGrades(student);
						break;
						
				case 0: UserCRSMenu.logout();
						break;
						
				default: logger.info(UIConstants.SELECT_CORRECT_OPTION_MESSAGE);
						 logger.info("\n");
						
			}
		}
	}

	/* // for debugging purposes
	public static void main(String[] args) {
		Student st = new Student();
		StudentCRSMenu scm = new StudentCRSMenu();
		scm.displayMenu(st);
	} */
}
