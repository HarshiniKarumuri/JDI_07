package com.flipkart.business;

import com.flipkart.bean.Professor;

/**
 * Professor business interface
 */
public interface ProfessorInterface {

	public void viewCatalog();

	public void viewStudentRegisteredInParticularCourse(int courseId);

	public void gradeStudent(Professor professor, int studentId, int courseId, int grade);
}
