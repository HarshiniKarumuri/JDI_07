package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.exception.AdminClientException;
import com.flipkart.service.NotificationOperations;
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
	AdminOperations adminOperation = AdminOperations.getInstance();
	NotificationOperations notificationOperations = NotificationOperations.getInstance();
	Scanner sc = new Scanner(System.in);

	/**
	 * Displays UI menu for user with admin role
	 *
	 * @param admin Admin object entering in CRS
	 */
	public void displayMenu(Admin admin) {

		// user input variables
		int choice;
		System.out.println(UserCRSMenu.loggedIn);

		// check if user logged in CRS
		while(UserCRSMenu.loggedIn){

			// options available for professor
			logger.info("-----------------------Enter your choice:------------------------");
			logger.info("0. To logout and return to Main Menu");
			logger.info("1. To see the List of Users");
			logger.info("2. To add professor or admin");
			logger.info("3. To assign Professor");
			logger.info("4. To delete user");
			logger.info("5. To view offered Course");
			logger.info("6. To add catalog");
			logger.info("7. To remove catalog");
			logger.info("8. To add course into catalog");
			logger.info("9. To remove course from catalog");
			logger.info("10. To add course into offered course");
			logger.info("11. To remove course from offered course");
			logger.info("12. To approve student profile");
			logger.info("13. To see the list of pending approvals");
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
					adminOperation.viewUser();
					break;
				case 2:
					addNewUser();
					break;
				case 3:
					assignProfessorToCourse();
					break;
				case 4:
					deleteUser();
					break;
				case 5:
					adminOperation.viewCoursesOffered();
					break;
				case 6:
					addCatalog();
					break;
				case 7:
					removeCatalog();
					break;
				case 8:
					addCourseIntoCatalog();
					break;
				case 9:
					removeCourseFromCatalog();
					break;
				case 10:
					addCourseToOffer();
					break;
				case 11:
					removeOfferedCourse();
					break;
				case 12:
					approveStudentProfile();
					break;
				case 13:
					viewPendingApprovals();
				default:
					logger.info(UIConstants.SELECT_CORRECT_OPTION_MESSAGE);
					logger.info("\n");
			}
		}
	}

	private void viewPendingApprovals() {
//		logger.info("In pending approvals");
		adminOperation.viewPendingApprovalStudent();
	}

	/**
	 * To approve student profile
	 */
	private void approveStudentProfile() {
		logger.info(UIConstants.REQUEST_STUDENT_ID_MESSAGE);
		int studentId = Integer.parseInt(sc.nextLine());

		adminOperation.approveStudent(studentId);
		notificationOperations.getNotification(studentId);
	}

    /**
     * Adds catalog into catalog table
     */
    void addCatalog() {
        logger.info(UIConstants.ADD_CATALOG_ID_MESSAGE);
        int catalogId = Integer.parseInt(sc.nextLine());
        logger.info(UIConstants.ADD_CATALOG_NAME_MESSAGE);
        String catalogName = sc.nextLine();
        adminOperation.addCatalog(catalogId, catalogName);
    }

    /**
     * Removes catalog from catalog table
     */
    void removeCatalog() {
        logger.info(UIConstants.ADD_CATALOG_ID_MESSAGE);
        int catalogId = Integer.parseInt(sc.nextLine());
        adminOperation.removeCatalog(catalogId);
    }

    /**
     * Adds course into course catalog
     */
    void addCourseIntoCatalog() {

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

        try {
            logger.info(UIConstants.ENTER_COURSE_CAPACITY);
            int capacity = Integer.parseInt(sc.nextLine());
            course.setCapacity(capacity);

            if (capacity < 3 || capacity > 10) {
                throw new AdminClientException("Capacity needs to be within 3 to 10");
            }
        } catch (AdminClientException | NumberFormatException e) {
            logger.error(e.getMessage());
        }
        logger.info(UIConstants.ADD_CATALOG_ID_MESSAGE);
        int catalogId = Integer.parseInt(sc.nextLine());

        adminOperation.addCourseIntoCatalog(course, catalogId);
    }

    /**
     * Remove Course from catalog
     */
    void removeCourseFromCatalog() {

        logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
        int courseId = Integer.parseInt(sc.nextLine());

        adminOperation.removeCourseFromCatalog(courseId);
    }

    /**
     * Adds a course to Offered course
     */
    void addCourseToOffer() {

        logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
        int courseId = Integer.parseInt(sc.nextLine());

        logger.info(UIConstants.ADD_CATALOG_ID_MESSAGE);
        int catalogId = Integer.parseInt(sc.nextLine());

        adminOperation.addCourseToOffer(courseId, catalogId);
    }

    /**
     * Remove an offered course
     */
    void removeOfferedCourse() {

        logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
        int courseId = Integer.parseInt(sc.nextLine());

        logger.info(UIConstants.ADD_CATALOG_ID_MESSAGE);
        int catalogId = Integer.parseInt(sc.nextLine());

        adminOperation.removeOfferedCourse(courseId, catalogId);
    }

    /**
     * Assign a professor to an offered course
     */
    void assignProfessorToCourse() {
        logger.info("Enter professor Id");
        int professorId = Integer.parseInt(sc.nextLine());
        logger.info("Enter course Id");
        int courseId = Integer.parseInt(sc.nextLine());
        adminOperation.assignProfessorToCourse(professorId, courseId);
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
        switch (option) {

            case 1:
                Admin admin = new Admin();
                logger.info("Enter email:");
                admin.setEmail(sc.nextLine());

                logger.info("Enter password");
                admin.setPassword(sc.nextLine());

                logger.info("Enter User name");
                admin.setUsername(sc.nextLine());

                admin.setRole("Admin");

                logger.info("Enter Gender");
                admin.setGender(sc.nextLine());

                logger.info("Enter Address");
                admin.setAddress(sc.nextLine());

                adminOperation.addAdmin(admin);
                break;

            case 2:
                Professor professor = new Professor();
                logger.info("Enter email:");
                professor.setEmail(sc.nextLine());

                logger.info("Enter password");
                professor.setPassword(sc.nextLine());

                logger.info("Enter User name");
                professor.setUsername(sc.nextLine());

                professor.setRole("Professor");

                logger.info("Enter Gender");
                professor.setGender(sc.nextLine());

                logger.info("Enter Address");
                professor.setAddress(sc.nextLine());

                logger.info("Enter Department");
                professor.setDepartment(sc.nextLine());

                adminOperation.addProfessor(professor);
                break;

            default:
                logger.warn("Option Invalid\n");
        }
    }
}