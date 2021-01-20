package com.flipkart.business;

import com.flipkart.bean.Professor;
import com.sun.istack.internal.logging.Logger;

public class ProfessorOperations implements ProfessorInterface {

	private static Logger logger = Logger.getLogger(ProfessorOperations.class);
	
	
	public void viewCatalog() {
		logger.info("In View Catalog");
	}

	public void viewStudentRegisteredInParticularCourse(int courseId) {
		logger.info("In view Student Registered In Particular Course");
	}
	
	public void gradeStudent(Professor professor,int studentId,int courseId,int grade) {
		logger.info("In grade Student");
	}
}
