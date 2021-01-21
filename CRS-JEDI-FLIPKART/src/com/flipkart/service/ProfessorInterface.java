package com.flipkart.service;

/**
 * Professor business interface
 */
public interface ProfessorInterface {

	/**
	 * To view courses in CRS taught by the professor
	 * @param professorId unique identifier of the professor
	 */
	void viewAssignedCourses(int professorId);

	/**
	 * To view students enrolled in a course in CRS taught by professor
	 *
	 * @param professorId unique identifier of the professor of course
	 * @param courseId unique identifier of the course to view enrolled students
	 */
	void viewStudentsRegisteredInCourse(int professorId, int courseId);

	/**
	 * To grade a student in a course taught by professor
	 *
	 * @param professorId unique identifier of the professor grading the course
	 * @param courseId unique identifier of course for which student is graded
	 * @param grade grade assigned to student in a course by the professor
	 * @param studentId unique identifier of student to whom grade is assigned
	 */
	void gradeStudent(int professorId, int courseId, String grade, int studentId);
}
