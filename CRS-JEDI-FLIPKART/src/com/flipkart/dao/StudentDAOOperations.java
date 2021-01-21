/**
 * 
 */
package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Student;
import com.flipkart.service.StudentInterface;
import com.flipkart.bean.Course;
/**
 * @author mayan
 *
 */
public class StudentDAOOperations implements StudentDAOInterface{

	public ArrayList<Course> getRegisteredCourses(Student student) {

		// dummy students data
		ArrayList<Course> courses = new ArrayList<Course>();

		Course course1 = new Course();
		course1.setCourseId(101);
		course1.setCourseName("DAA");
		course1.setDescription("Course Description");
		course1.setFees(100);
		
		Course course2 = new Course();
		course2.setCourseId(102);
		course2.setCourseName("DSA");
		course2.setDescription("Course Description");
		course2.setFees(100);

		courses.add(course1);
		courses.add(course2);
		return courses;
	}
	
	
	public void addCourse(Student student,int courseId) {
		
		
	}
	
	
	public void dropCourse(Student student,int courseId) {
		
	}
}
