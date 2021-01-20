package com.flipkart.business;

import com.flipkart.bean.Professor;

/**
 * Professor business interface
 */
public interface ProfessorInterface {

	public void viewCatalog();
	
	public void getCourseTaught(Professor professor);

	public void viewStudents(Professor professor);

	public void gradeStudent(Professor professor, int studentId, int courseId, int grade);
}
