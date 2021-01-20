package com.flipkart.business;

import com.flipkart.bean.Professor;

/**
 * Professor business interface
 */
public interface ProfessorInterface {

	public void getCoursesTaught(Professor professor);

	public void viewStudents(Professor professor);

	void gradeStudent(Professor professor, int studentId, int courseId, int grade);
}
