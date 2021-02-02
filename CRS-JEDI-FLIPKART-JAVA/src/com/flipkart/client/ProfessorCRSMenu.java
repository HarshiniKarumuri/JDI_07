package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorOperations;
import com.flipkart.constants.UIConstants;

/**
 * Professor main class (user interface)
 */
public class ProfessorCRSMenu {

    private static final Logger logger = Logger.getLogger(ProfessorCRSMenu.class);
    ProfessorOperations professorOperation = ProfessorOperations.getInstance();
    Scanner sc = new Scanner(System.in);

    /**
     * Display Professor's Menu
     *
     * @param professor
     */
    public void displayMenu(Professor professor) {

        // user input variables
        int choice, courseId, studentId;
        String grade;

        // check if user logged in CRS
        while (UserCRSMenu.loggedIn) {

            // options available for professor
            logger.info("-----------------------Enter your choice:------------------------");
            logger.info("0. To logout and return to main menu");
            logger.info("1. To view courses assigned to you");
            logger.info("2. To view students in a course");
            logger.info("3. To add or update grade of a student in a course");
            logger.info("------------------------------------------------------------------");
            choice = Integer.parseInt(sc.nextLine());
            //sc.nextLine();
            logger.info("\n");

            // switch to the selected choice
            switch (choice) {
                case 1:
                    professorOperation.viewAssignedCourses(professor.getProfessorId());
                    break;

                case 2:
                    logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
                    courseId = Integer.parseInt(sc.nextLine());

                    professorOperation.viewStudentsRegisteredInCourse(professor.getProfessorId(), courseId);
                    break;

                case 3:
                    logger.info(UIConstants.REQUEST_COURSE_ID_MESSAGE);
                    courseId = Integer.parseInt(sc.nextLine());
                    logger.info(UIConstants.REQUEST_STUDENT_ID_MESSAGE);
                    studentId = Integer.parseInt(sc.nextLine());
                    //sc.nextLine();
                    logger.info(UIConstants.REQUEST_STUDENT_GRADE_MESSAGE);
                    grade = sc.nextLine();

                    professorOperation.gradeStudent(professor.getProfessorId(), courseId, grade, studentId);
                    break;

                case 0:
                    UserCRSMenu.logout();
                    break;

                default:
                    logger.info(UIConstants.SELECT_CORRECT_OPTION_MESSAGE);
                    logger.info("\n");
            }


        }
        //sc.close();
    }
}
