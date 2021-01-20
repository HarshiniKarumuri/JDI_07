package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;
import java.util.logging.Logger;

/**
 * Professor business class implements ProfessorInterface
 */
public class ProfessorOperations implements ProfessorInterface {

	private ProfessorDaoInterface professorDao = new ProfessorDaoOperations();
	private static Logger logger = Logger.getLogger(ProfessorOperations.class.getName());

	@Override
	public void viewAssignedCourses(int professorId) {
		logger.info("-------------- Assigned Courses --------------\n");
		logger.info(String.format("%-10s%-10s%-10s", "Course Id", "Course Name", "Course Description"));
		List<Course> coursesList = professorDao.getAssignedCourses(professorId);
		if(coursesList.size() == 0) {
			logger.info("No courses assigned");
		} else {
			coursesList.forEach(course ->
					logger.info(String.format("%-10s%-10s%-10s", course.getCourseId(), course.getCourseName(), course.getDescription()))
			);
		}
		logger.info("\n--------------------------------------------------\n");
	}

	@Override
	public void viewStudentsRegisteredInCourse(int professorId, int courseId) {
		logger.info("-------------- Registered Students in Course --------------\n");
		logger.info(String.format("Course ID : %s\n", courseId));
		logger.info(String.format("%-10s%-10s%-10s", "Course Id", "Course Name", "Course Description"));
		List<Student> studentsList = professorDao.getStudentsRegisteredInCourse(professorId, courseId);
		if(studentsList.size() == 0) {
			logger.info("No students registered in this course");
		} else {
			studentsList.forEach(student ->
					logger.info(String.format("%-10s%-10s%-10s", student.getStudentId(), student.getStudentName(), student.getBranch()))
			);
		}
		logger.info("\n----------------------------------------\n");
	}

	@Override
	public void gradeStudent(Professor professor, int studentId, int courseId, int grade) {
		professorDao.gradeStudent(professor, studentId, courseId, grade);
	}
}
