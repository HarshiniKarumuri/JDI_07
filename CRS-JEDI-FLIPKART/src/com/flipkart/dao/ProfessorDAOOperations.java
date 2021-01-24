package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class ProfessorDAOOperations implements ProfessorDAOInterface {

	private static final Logger logger = Logger.getLogger(ProfessorDAOOperations.class.getName());

	//TODO: implement data fetch using SQL queries
	public List<Student> getRegisteredStudentsInCourse(int professorId, int courseId) {

		// dummy students data
		List<Student> students = new ArrayList<Student>();

		Student student1 = new Student();
		student1.setStudentId(101);
		student1.setUsername("Harry");
		student1.setBranch("CSE");
		student1.setGender("Male");
		student1.setHasScholarship(true);
		student1.setIsApproved(0);
		students.add(student1);
		
		Student student2 = new Student();
		student2.setStudentId(102);
		student2.setUsername("Hermonie");
		student2.setBranch("ECE");
		student2.setGender("Female");
		student2.setHasScholarship(false);
		student2.setIsApproved(1);
		students.add(student2);

		return students;
	}

	//TODO: implement data fetch using SQL queries
	public List<Course> getAssignedCourses(int professorId){

		// dummy courses data
		List<Course> courses = new ArrayList<>();
		
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
		
		return courses;
	}

	//TODO: implement data fetch using SQL queries
	public void gradeStudent(int courseId, int studentId, String grade) {}

	//TODO: implement data fetch using SQL queries
	@Override
	public boolean checkCanGradeCourse(int professorId, int courseId) {
		return true;
	}

	//TODO: implement data fetch using SQL queries
	@Override
	public boolean checkCanGradeStudent(int studentId, int courseId) {
		return true;
	}

	//TODO: implement data fetch using SQL queries
	@Override
	public Professor getProfessorDetails(String username) {

		// dummy professor
		Professor professor = new Professor();
		professor.setUsername("Mr. Aman");
		professor.setProfessorId(2223423);
		professor.setUserId(1233334);
		professor.setUsername("aman.rocks");
		professor.setEmail("aman.rocks@crshome.com");

		return professor;
	}

	/*For debugging purposes
	public static void main(String[] args) {
		
		ProfessorDAOImpl pdl = new ProfessorDAOImpl();
		Professor prof = new Professor();
		pdl.viewStudents(prof);
		
		List<Course> courses = pdl.getCourses(prof);
		for(Course cou : courses) {
			logger.info(cou.getCourseId()+" "+cou.getCourseName());
			
		}
		
	}*/
}
