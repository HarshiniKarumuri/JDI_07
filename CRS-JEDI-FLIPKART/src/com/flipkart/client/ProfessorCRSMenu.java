package com.flipkart.client;

import java.util.Scanner;
import java.util.logging.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.business.ProfessorOperations;

/**
 * Professor main class (user interface)
 */
public class ProfessorCRSMenu {
	
	private static Logger logger = Logger.getLogger(ProfessorCRSMenu.class);
	ProfessorOperations professorOperation = new ProfessorOperations();
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu(Professor professor) {
		int choice;
		while(UserCRSMenu.loggedIn()){
			//Logging statements
			logger.info("Enter your choice:");
			logger.info("0. To logout");
			logger.info("1. To view courses taught");
			logger.info("2. To view students in a course");
			logger.info("3. To add Grades of a student");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) 
			{
				case 1:
					professorOperation.getCoursesTaught(professor);
					break;
				case 2:
					professorOperation.viewStudents(professor);
					break;
				case 3:
					logger.info("Enter course id: ");
					int courseId = sc.nextInt();
					
					//if Professor teaches that course
					
					if(ProfessorDaoImpl.checkValidCourseForProfessor(professor, courseId)) 
					{
						logger.info("Enter student id: ");
						int studentId = sc.nextInt();
						
						//if that particular student is enrolled for  that course
						
						if(ProfessorDaoImpl.checkValidCourseForStudent(studentId, courseId))
						{
							logger.info("Enter grades:");
							String grades = sc.nextLine();
							professorOperation.gradeStudent(professor, studentId, grades, courseId);
						}
						else
						{
							
							logger.info("Student has not registered for this course");
						}
					}
					else 
					{
						logger.info("This course is not taught by you.");
					}
					
					break;
				case 0:
					UserCRSMenu.logout();
					break;
			}
			
		}
		sc.close();
	}

}
