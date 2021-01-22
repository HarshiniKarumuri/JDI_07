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

	/**
	 * Displays UI menu for user with admin role
	 *
	 * @param admin Admin object entering in CRS
	 */
	public void displayMenu(Admin admin) {
 
		// user input variables
		int choice, courseId, studentId;
		String grade;
 
		// check if user logged in CRS
		while(UserCRSMenu.loggedIn){
 
			// options available for professor
			logger.info("-----------------------Enter your choice:------------------------");
			logger.info("0. To logout and return to Main Menu");
			logger.info("1. To view the offered courses in course catalog");
			logger.info("2. To add a course into offered courses");
			logger.info("3. To remove a course from offered courses");
			logger.info("4. To add a professor user");
			logger.info("5. To assign a professor to a course");
			logger.info("6. To delete a user");
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
					adminOperation.viewCoursesOffered();
					break;
 
				case 2:
					addCourseToOffer();
					break;
 
				case 3:
					removeOfferedCourse();
					break;
 
				case 4:
					addNewUser();
					break;

				case 5:
					assignProfessorToCourse();
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

	/**
	 * Add course to offered courses from courses catalog
	 */
	void addCourseToOffer() {
		
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
		adminOperation.addCourseToOffer(course);
	}

	/**
	 * Remove an offered course
	 */
	void removeOfferedCourse() {
		logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
		int courseId = Integer.parseInt(sc.nextLine());
		adminOperation.removeOfferedCourse(courseId);
	}

	/**
	 * Assign a professor to an offered course
	 */
	void assignProfessorToCourse() {
		
		logger.info("Enter professor Id");
		int professorId = Integer.parseInt(sc.nextLine());
		Professor professor = new Professor();
		professor.setProfessorId(professorId);
		logger.info("Enter course Id");
		int courseId = Integer.parseInt(sc.nextLine());
		
		adminOperation.assignProfessorToCourse(professor, courseId);
	}

	/**
	 * Delete an existing account of a user in CRS
	 */
	void deleteUser() {
		logger.info("Enter user id:");
		adminOperation.deleteUser(Integer.parseInt(sc.nextLine()));
	}

	/**
	 * Register an account of professor or admin user in CRS
	 */
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
				admin.setUsername(sc.nextLine());
				logger.info("Enter password");
				String password = sc.nextLine();
				adminOperation.addAdmin(admin, password);
				break;
				
			case 2:
				Professor professor = new Professor();
				logger.info("Enter professor id:");
				professor.setProfessorId(Integer.parseInt(sc.nextLine()));
				logger.info("Enter professor name:");
				professor.setUsername(sc.nextLine());
				logger.info("Enter password");
				password = sc.nextLine();
				adminOperation.addProfessor(professor, password);
				break;
				
			default:
				logger.warn("Option Invalid\n");
		}
	}
 
}