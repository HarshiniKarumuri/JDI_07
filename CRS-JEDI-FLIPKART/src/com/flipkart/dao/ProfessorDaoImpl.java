package com.flipkart.dao;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class ProfessorDaoImpl implements ProfessorDao {
	
	public static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);
	
	// to Fetch details of prfessor by his username
	public Professor getProfessorDetails(String username) {
		logger.info("In -> ProfessorDaoOperations.getProfessorDetails()");
		Professor professor = new Professor();
		professor.setName("Amit");
		professor.setEmail("amit@gmail.com");
		professor.setCourseId(10);
		professor.setProfessorId(1);
		professor.setUsername("amit@balyan");
		return professor;
	}
	
	//To view student in profs particular course
	public List<Student> viewStudents(Professor professor) {
		List<Student> students = new ArrayList<Student>();
		
		Student student1 = new Student();
		student1.setStudentId(101);
		student1.setName("Harry");
		student1.setBranch("CSE");
		student1.setGender("Male");
		student1.setHasScholarship(true);
		student1.setIsRegistered(0);
		students.add(student1);
		
		Student student2 = new Student();
		student2.setStudentId(102);
		student2.setName("Hermonie");
		student2.setBranch("ECE");
		student2.setGender("Female");
		student2.setHasScholarship(false);
		student2.setIsRegistered(1);
		students.add(student2);
		
		for(Student stud: students) {
			logger.info(stud.getStudentId()+" "+stud.getName());
		}
		
		return students;
		
	}
	
	// View courses taught
	public List<Course> getCourses(Professor professor){ 
		List<Course> courses = new ArrayList<Course>();
		
		Course course1 = new Course();
		course1.setCourseId(1);
		course1.setCourseName("Java");
		course1.setDescription("Programming Language");
		course1.setFees(100000);
		courses.add(course1);
		
		Course course2 = new Course();
		course2.setCourseId(2);
		course2.setCourseName("ML");
		course2.setDescription("A good course");
		course2.setFees(200000);
		courses.add(course2);
		
		for(Course course:courses) {
			logger.info(course.getCourseId() + " - " + course.getCourseName());
		}
		
		return courses; 
	}
	
	// Grade Student
	public void gradeStudent(Professor professor, int courseId, int studentId, String grade ) {}
	

}
