package com.flipkart.client;

import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.service.CourseCatalogOperations;
import com.flipkart.service.StudentOperations;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Student main class (user interface)
 */
public class StudentCRSMenu {

    private static final Logger logger = Logger.getLogger(StudentCRSMenu.class.getName());
    private final Scanner scanner = new Scanner(System.in);

    private final StudentOperations studentOperations = StudentOperations.getInstance();
    private final CourseCatalogOperations catalogOperations = CourseCatalogOperations.getInstance();

    public void displayMenu(Student student) {
        // input variables
        int courseId, choice;
        int fees;

        try {
            // check if user is logged in
            while (UserCRSMenu.loggedIn) {
            	
            	boolean isApproved = studentOperations.isStudentProfileApproved(student.getStudentId());
            	if(!isApproved) {
            		logger.info("Your profile is not approved by admin!!!");
            		UserCRSMenu.logout();
            		continue;
            	}
                // Options available for student
                logger.info(UIConstants.ENTER_CHOICES_MESSAGE);
                logger.info("0. To logout and return to main menu");
                logger.info("1. To view available courses");
                logger.info("2. To view details of a course");
                logger.info("3. To register a course");
                logger.info("4. To drop a course");
                logger.info("5. To view registered courses");
                logger.info("6. To pay fees");
                logger.info("7. To view grades");
                logger.info(UIConstants.DASHED_LINE);
                choice = Integer.parseInt(scanner.nextLine());
                logger.info("\n");

                //switch to the selected choice
                switch (choice) {
                    case 1:
                        catalogOperations.viewCoursesOffered();
                        break;

                    case 2:
                        logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
                        courseId = Integer.parseInt(scanner.nextLine());
                        catalogOperations.viewCourseDetails(courseId);
                        break;

                    case 3:
                        logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
                        courseId = Integer.parseInt(scanner.nextLine());
                        studentOperations.registerCourse(student.getStudentId(), courseId);
                        break;

                    case 4:
                        logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
                        courseId = Integer.parseInt(scanner.nextLine());
                        studentOperations.dropCourse(student.getStudentId(), courseId);
                        break;

                    case 5:
                        studentOperations.viewRegisteredCourses(student.getStudentId());
                        break;

                    case 6:
                        logger.info(UIConstants.SELECT_PAY_MODE_MESSAGE);

                        fees = studentOperations.calculateFees(student.getStudentId());
                        logger.info("You have to pay " + fees + "/- Rupees only.");
                        logger.info("1. Cash\n2. Card\n3. Net Banking\n0. Cancel\n");
                        choice = Integer.parseInt(scanner.nextLine());
                        studentOperations.makePayment(student.getStudentId(), choice, fees);
                        break;

                    case 7:
                        studentOperations.viewGrades(student.getStudentId());
                        break;

                    case 0:
                        UserCRSMenu.logout();
                        break;

                    default:
                        logger.info(UIConstants.SELECT_CORRECT_OPTION_MESSAGE);
                        logger.info("\n");
                }
            }
        } catch (NumberFormatException e) {
            logger.error(UIConstants.WRONG_INPUT_MESSAGE);
        }
    }
}
