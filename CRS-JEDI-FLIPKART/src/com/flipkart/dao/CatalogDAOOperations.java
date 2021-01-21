package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;

public class CatalogDAOOperations implements CatalogDAOInterface {

	@Override
	public ArrayList<Course> viewCatalog() {
		// TODO Auto-generated method stub
		
		//Dummy Data
		ArrayList<Course> courses = new ArrayList<Course>();
		
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

	@Override
	public Course viewCourse(int courseId) {
		// TODO Auto-generated method stub
		
		//Dummy Data
		Course course1 = new Course();
		course1.setCourseId(1);
		course1.setCourseName("Java");
		course1.setDescription("Programming Language");
		course1.setFees(100000);
		
		return course1;
	}

}
