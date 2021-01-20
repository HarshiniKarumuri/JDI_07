package com.flipkart.business;

import com.flipkart.bean.Professor;

/**
 * Professor business interface
 */
interface ProfessorInterface {

	/**
	 * To view course catalog in CRS
	 * @param professorId
	 */
	void viewAssignedCourses(int professorId);

	/**
	 * To view students registered in a course in CRS
	 *
	 * @param professorId
	 * @param courseId unique identifier of the course to view
	 *
	 */
	void viewStudentsRegisteredInCourse(int professorId, int courseId);

	/**
	 * To grade a student in a course
	 *
	 * @param professor object of Professor assigning the grade
	 * @param studentId	unique identifier of Student to whom grade is assigned
	 * @param courseId	unique identifier of Course for which Student is graded
	 * @param grade grade assigned to Student in a Course by the Professor
	 */
	void gradeStudent(Professor professor, int studentId, int courseId, int grade);
}
