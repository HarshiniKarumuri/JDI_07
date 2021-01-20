package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface ProfessorDao {
	
	public Professor getProfessorDetails(String username);
	
	public List<Student> viewStudents(Professor professor);
	
	public List<Course> getCourses(Professor professor);
	
	public void gradeStudent(Professor professor, int courseId, int studentId, String grade );

}
