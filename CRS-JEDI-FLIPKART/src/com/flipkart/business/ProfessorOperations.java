package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.dao.ProfessorDAOInterface;
import com.flipkart.dao.ProfessorDAOOperations;

import java.util.List;
import java.util.logging.Logger;

/**
 * Professor business class implements ProfessorInterface
 */
public class ProfessorOperations implements ProfessorInterface {

	private final ProfessorDAOInterface professorDao = new ProfessorDAOOperations();
	private static final Logger logger = Logger.getLogger(ProfessorOperations.class.getName());

	@Override
	public void viewAssignedCourses(int professorId) {
		logger.info("-------------- Assigned Courses --------------\n");
		logger.info(String.format("%-15s%-15s%-15s", "Course Id", "Course Name", "Course Description"));
		List<Course> coursesList = professorDao.getAssignedCourses(professorId);
		if(coursesList.size() == 0) {
			logger.info(UIConstants.NO_COURSE_ASSIGNED_MESSAGE);
		} else {
			coursesList.forEach(course ->
					logger.info(String.format("%-10s%-10s%-10s", course.getCourseId(), course.getCourseName(), course.getDescription()))
			);
		}
		logger.info("\n--------------------------------------------------\n");
	}

	@Override
	public void viewStudentsRegisteredInCourse(int professorId, int courseId) {
		if(professorDao.checkCanGradeCourse(professorId, courseId)) {

			logger.info("-------------- Registered Students in Course --------------\n");
			logger.info(String.format("Course ID : %s\n", courseId));
			logger.info(String.format("%-15s%-15s%-15s", "Student Id", "Student Name", "Course"));
			List<Student> studentsList = professorDao.getRegisteredStudentsInCourse(professorId, courseId);
			if(studentsList.size() == 0) {
				logger.info(UIConstants.NO_STUDENT_REGISTERED_MESSAGE);
			} else {
				studentsList.forEach(student ->
						logger.info(String.format("%-10s%-10s%-10s", student.getStudentId(), student.getStudentName(), student.getBranch()))
				);
			}
			logger.info("\n-----------------------------------------------------\n");

		} else {
			logger.info(UIConstants.COURSE_NOT_TAUGHT_MESSAGE);
			logger.info("\n");
		}
	}

	@Override
	public void gradeStudent(int professorId, int courseId, String grade, int studentId) {
		if(professorDao.checkCanGradeCourse(professorId, courseId)) {

			if(professorDao.checkCanGradeStudent(studentId, courseId)) {

				professorDao.gradeStudent(courseId, studentId, grade);
				logger.info(UIConstants.SUCCESS_STUDENT_GRADED_MESSAGE);

			} else {
				logger.info(UIConstants.STUDENT_NOT_REGISTERED_MESSAGE);
				logger.info("\n");
			}
		} else {
			logger.info(UIConstants.COURSE_NOT_TAUGHT_MESSAGE);
			logger.info("\n");
		}
	}
}
