package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;

public class AdminDAOOperations implements AdminDAOInterface{

	@Override
	public ArrayList<User> viewUser() {
		// TODO Auto-generated method stub
		ArrayList<User> l1 = new ArrayList<User>();
		
		//Dummy data
		User u1 = new User();
		u1.setUserId(0);
		u1.setUsername("Narendra Modi");
		l1.add(u1);
		
		User u2 = new User();
		u1.setUserId(1);
		u1.setUsername("Rahul Gandhi");
		l1.add(u2);
		
		return l1;
	}

	@Override
	public void addCourseIntoCatalog(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void assignProfessor(Professor professor, int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

}
