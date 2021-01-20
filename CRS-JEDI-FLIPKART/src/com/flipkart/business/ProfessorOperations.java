package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.ProfessorDaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ProfessorOperations implements ProfessorInterface {

	public static Logger logger = Logger.getLogger(ProfessorOperations.class);
	
	public void viewCatalog() {
		logger.info("In ProfessorOperations -> viewCatalog()");
	}
	
	public void getCourseTaught(Professor professor) {
		logger.info("In ProfessorOperations -> getCourseTaught()");
		ProfessorDaoImpl professorDaoImpl = new ProfessorDaoImpl();
		List<Course> courses = new ArrayList<Course>();
		courses = professorDaoImpl.getCourses(professor);
		for(Course course:courses) {
			logger.info(course.getCourseId() + " " + course.getCourseName());
		}
	}

	public void viewStudents(Professor professor) {
		logger.info("In ProfessorOperations -> viewStudents()");
		ProfessorDaoImpl professorDaoImpl = new ProfessorDaoImpl();
		List<Student> students = new ArrayList<Student>();
		students = professorDaoImpl.viewStudents(professor);
		for(Student stud: students) {
			logger.info(stud.getStudentId()+ " " +stud.getName());
		}
		
	}
	
	public void gradeStudent(Professor professor,int studentId,int courseId,int grade) {
		logger.info("In ProfessorOperations -> gradeStudent()");
		ProfessorDaoImpl professorDaoImpl = new ProfessorDaoImpl();
		professorDaoImpl.gradeStudent(professor,101,44,"AA");
	}
}
