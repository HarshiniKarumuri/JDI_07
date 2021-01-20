package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

public interface ProfessorDAO {
	// View students in professor's course
		public void viewStudents(Professor professor);
		
		// View courses taught
		public List<Course> getCourses(Professor professor);
		
		// Grade Student
		public void gradeStudent(Professor professor, int courseId, int studentId, String grade);

}
