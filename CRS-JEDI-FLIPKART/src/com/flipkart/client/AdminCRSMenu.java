package com.flipkart.client;
 
import java.util.Scanner;
 
import org.apache.log4j.Logger;
 
import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.constants.UIConstants;
import com.flipkart.service.AdminOperations;
 
/**
 * Admin main class (user interface)
 */
public class AdminCRSMenu {
 
	
	private static final Logger logger = Logger.getLogger(AdminCRSMenu.class);
	AdminOperations adminOperation = new AdminOperations();
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu(Admin admin) {
 
		// user input variables
		int choice, courseId, studentId;
		String grade;
 
		// check if user logged in CRS
		while(UserCRSMenu.loggedIn){
 
			// options available for professor
			logger.info("-----------------------Enter your choice:------------------------");
			logger.info("0. To logout and return to Main Menu");
			logger.info("1. To view Catalogue");
			logger.info("2. To add a Course into the Catalogue");
			logger.info("3. To delete a Course");
			logger.info("4. To add a Professor");
			logger.info("5. To assign a Professor");
			logger.info("6. To delete a User");
			logger.info("------------------------------------------------------------------");
			choice = sc.nextInt();
			sc.nextLine();
			logger.info("\n");
 
			// switch to the selected choice
			switch(choice) 
			{
				case 0:
					UserCRSMenu.logout();
					break;
				case 1:
					adminOperation.viewCatalog();
					break;
 
				case 2:
					addNewCourse();
					break;
 
				case 3:
					deleteCourse();
					break;
 
				case 4:
					addNewUser();
					break;
				case 5:
					assignProfessor();
					break;
				case 6:
					deleteUser();
					break;
				default:
					logger.info(UIConstants.SELECT_CORRECT_OPTION_MESSAGE);
					logger.info("\n");
			}
			
			
		}
		
	}
	void addNewCourse() {
		
		Course course = new Course();
		logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
		int courseId = Integer.parseInt(sc.nextLine());
		course.setCourseId(courseId);
		logger.info(UIConstants.REQUEST_COURSE_NAME_MESSAGE);
		String courseName = sc.nextLine();
		course.setCourseName(courseName);
		logger.info(UIConstants.REQUEST_COURSE_DESCRIPTION_MESSAGE);
		String description = sc.nextLine();
		course.setDescription(description);
		logger.info(UIConstants.REQUEST_COURSE_FEE_MESSAGE);
		int fees = Integer.parseInt(sc.nextLine());
		course.setFees(fees);
		adminOperation.addCourseIntoCatalog(course);
		
	}
	
	void deleteCourse() {
		logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
		int courseId = Integer.parseInt(sc.nextLine());
		adminOperation.deleteCourse(courseId);
	}
	
	void assignProfessor() {
		
		logger.info("Enter professor Id");
		int professorId = Integer.parseInt(sc.nextLine());
		Professor professor = new Professor();
		professor.setProfessorId(professorId);
		logger.info("Enter course Id");
		int courseId = Integer.parseInt(sc.nextLine());
		
		adminOperation.assignProfessor(professor, courseId);
	}
	
	void deleteUser() {
		logger.info("Enter user id:");
		adminOperation.deleteUser(Integer.parseInt(sc.nextLine()));
	}
	
	void addNewUser() {
		
		logger.info("Enter 1 to add a new admin");
		logger.info("Enter 2 to add a new professor");
		
		int option = Integer.parseInt(sc.nextLine());
		
		switch(option) {
		
			case 1:
				Admin admin = new Admin();
				logger.info("Enter admin id:");
				admin.setAdminId(Integer.parseInt(sc.nextLine()));
				logger.info("Enter admin name:");
				admin.setAdminName(sc.nextLine());
				logger.info("Enter password");
				String password = sc.nextLine();
				adminOperation.addAdmin(admin, password);
				break;
				
			case 2:
				Professor professor = new Professor();
				logger.info("Enter professor id:");
				professor.setProfessorId(Integer.parseInt(sc.nextLine()));
				logger.info("Enter professor name:");
				professor.setProfessorName(sc.nextLine());
				logger.info("Enter password");
				password = sc.nextLine();
				adminOperation.addProfessor(professor, password);
				break;
				
			default:
				logger.warn("Option Invalid\n");
		}
	}
 
}