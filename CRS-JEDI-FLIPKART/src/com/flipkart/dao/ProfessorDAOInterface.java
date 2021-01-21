package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

/**
 * Professor Data Access Object interface
 */
public interface ProfessorDAOInterface {

	/**
	 * fetch students data enrolled in course of professor in CRS
	 *
	 * @param professorId unique identifier of the professor of course
	 * @param courseId unique identifier of the course to get enrolled students
	 * @return list of students enrolled in given course and professor
	 */
    List<Student> getRegisteredStudentsInCourse(int professorId, int courseId);

	/**
	 * fetch courses data taught by professor in CRS
	 *
	 * @param professorId unique identifier of the professor
	 * @return list of courses assigned to the professor to teach
	 */
	List<Course> getAssignedCourses(int professorId);

	/**
	 * update grade data of a student in a course
	 *
	 * @param courseId unique identifier of the course to grade enrolled students
	 * @param studentId unique identifier of the student to be graded
	 * @param grade grade assigned to student in a course
	 */
    void gradeStudent(int courseId, int studentId, String grade);

	/**
	 * Checks whether the professor is grading only the course he/she is teaching
	 *
	 * @param professorId unique identifier of the professor grading the course
	 * @param courseID unique identifier of course for which professor is grading
	 * @return true if professor is teaching that course else false
	 */
	boolean checkCanGradeCourse(int professorId, int courseID);

	/**
	 * Checks whether the student is in the course so that professor can grade him/her
	 *
	 * @param studentId unique identifier of the student whose grade needs to be assigned
	 * @param courseID unique identifier of course for which professor is grading
	 * @return true if student is enrolled in the course else false
	 */
	boolean checkCanGradeStudent(int studentId, int courseID);

}
