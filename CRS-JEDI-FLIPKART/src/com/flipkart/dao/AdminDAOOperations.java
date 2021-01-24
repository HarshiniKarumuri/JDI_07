package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;

public class AdminDAOOperations implements AdminDAOInterface{

	@Override
	public ArrayList<User> viewUser() {
		// TODO Auto-generated method stub
		ArrayList<User> l1 = new ArrayList<>();
		
		//Dummy data
		User u1 = new User();
		u1.setUserId(0);
		u1.setUsername("Narendra Modi");
		l1.add(u1);
		
		User u2 = new User();
		u2.setUserId(1);
		u2.setUsername("Rahul Gandhi");
		l1.add(u2);
		
		return l1;
	}

	@Override
	public void addCourseToOffer(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOfferedCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(Professor professor,String password) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void assignProfessorToCourse(Professor professor, int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAdmin(Admin admin, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin getAdminDetails(String username) {
		// TODO Auto-generated method stub
		
		Admin admin = new Admin();
		admin.setAdminId(0);
		admin.setUsername("Arvind Kejriwal");
		admin.setUsername(username);
		return admin;
	}

}
