/**
 * 
 */
package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * @author mayan
 *
 */
public interface StudentDAOInterface {

	public ArrayList<Course> getRegisteredCourses(Student student);
	public void addCourse(Student student,int courseId);
	public void dropCourse(Student student,int courseId);
}
