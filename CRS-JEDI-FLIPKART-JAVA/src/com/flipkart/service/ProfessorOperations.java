package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.ProfessorDAOInterface;
import com.flipkart.dao.ProfessorDAOOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flipkart.utils.PrintTabularInterface;
import com.flipkart.utils.StringFormatUtil;
import org.apache.log4j.Logger;

/**
 * Professor business class implements ProfessorInterface
 */
public class ProfessorOperations implements ProfessorInterface {

    private final ProfessorDAOInterface professorDao = ProfessorDAOOperations.getInstance();
    private static final Logger logger = Logger.getLogger(ProfessorOperations.class);

    private static volatile ProfessorOperations instance = null;

    // private constructor
    private ProfessorOperations() {
    }

    public static ProfessorOperations getInstance() {
        if (instance == null) {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized (ProfessorOperations.class) {
                instance = new ProfessorOperations();
            }
        }
        return instance;
    }

    private List<String> getAsList(Course course) {
        return new ArrayList<>(Arrays.asList(Integer.toString(course.getCourseId()), course.getCourseName(), course.getDescription()));
    }

    @Override
    public void viewAssignedCourses(int professorId) {
        List<Course> courses = professorDao.getAssignedCourses(professorId);
        if (courses.size() == 0) {
            logger.info(UIConstants.NO_COURSE_ASSIGNED_MESSAGE);
        } else {
            List<String> columnNames = Arrays.asList("Course ID", "Course Name", "Course Description");
            PrintTabularInterface fn = param -> getAsList((Course) param);
            StringFormatUtil.printTabular(logger, columnNames, courses, fn);
        }
    }

    private List<String> getAsListStudent(Student student) {
        return new ArrayList<>(Arrays.asList(Integer.toString(student.getStudentId()), student.getUsername(), student.getBranch()));
    }

    @Override
    public void viewStudentsRegisteredInCourse(int professorId, int courseId) {
        if (professorDao.checkCanGradeCourse(professorId, courseId)) {

            logger.info(String.format("Course ID : %s\n", courseId));
            List<Student> studentsList = professorDao.getRegisteredStudentsInCourse(professorId, courseId);
            if (studentsList.size() == 0) {
                logger.info(UIConstants.NO_STUDENT_REGISTERED_MESSAGE);
            } else {
                List<String> columnNames = Arrays.asList("Student ID", "Student Name", "Course");
                PrintTabularInterface fn = param -> getAsListStudent((Student) param);
                StringFormatUtil.printTabular(logger, columnNames, studentsList, fn);
            }

        } else {
            logger.info(UIConstants.COURSE_NOT_TAUGHT_MESSAGE);
            logger.info("\n");
        }
    }

    @Override
    public void gradeStudent(int professorId, int courseId, String grade, int studentId) {
        if (professorDao.checkCanGradeCourse(professorId, courseId)) {

            if (professorDao.checkCanGradeStudent(studentId, courseId)) {

                professorDao.gradeStudent(courseId, studentId, grade);
                logger.info(UIConstants.SUCCESS_STUDENT_GRADED_MESSAGE);

            } else {
                logger.info(UIConstants.STUDENT_NOT_REGISTERED_MESSAGE);
            }
        } else {
            logger.info(UIConstants.COURSE_NOT_TAUGHT_MESSAGE);
        }
        logger.info("\n");
    }
}
