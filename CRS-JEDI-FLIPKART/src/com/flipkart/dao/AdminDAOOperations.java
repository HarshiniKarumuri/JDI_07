package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

public class AdminDAOOperations implements AdminDAOInterface{

	public static Logger logger = Logger.getLogger(AdminDAOOperations.class);
	Connection connection = DBUtils.getConnection();
	
	/*public static void main(String args[]) {
		PreparedStatement statement = null;
		int rows;
		User user = new User();
		user.setUserId(0);
		user.setEmail("nilshah117@gmail.com");
		user.setPassword("1111");
		user.setRole("Admin");
		Connection connection = DBUtils.getConnection();
		try {
			
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_ADMIN_QUERY);
			statement.setInt(1, 2);
			logger.info("hello world");
			ResultSet rs = statement.executeQuery();
			rs.next();
			logger.info(rs.getString(1));
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println("querying SELECT * FROM XXX " + columnsNumber);
			   
			   while (rs.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           String columnValue = rs.getString(i);
			           System.out.print(i + " " + columnValue + " " + rsmd.getColumnName(i) +"\n");
			       }
			       System.out.println("");
			   }
			//statement = connection.prepareStatement(SQLQueriesConstants.ADD_ADMIN_QUERY);
			//statement.setInt(1, 1); 
			//statement.setString(2,"m");
			//statement.setString(3,"nvs"); 
			//statement.setString(4, "nil"); 
			//rows = statement.executeUpdate();
			//logger.info(rows + " added in Admin");
			 
			
			//statement = connection.prepareStatement(SQLQueriesConstants.DELETE_USER_QUERY);
			//statement.setInt(1,1);
			//statement.setString(1,user.getEmail());
			//statement.setString(2,user.getPassword());
			//statement.setString(3,user.getRole());
			//rows = statement.executeUpdate();
			//logger.info(rows + " deleted from User");
			
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}*/
	
	@Override
	public ArrayList<User> viewUser() {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_USERS_QUERY);
			ResultSet rs = statement.executeQuery(SQLQueriesConstants.VIEW_USERS_QUERY);
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setRole(rs.getString(4));
				userList.add(user);
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return userList;
	}

	
	@Override
	public int addProfessor(Professor professor,String password) {
		// TODO Auto-generated method stub
		
		PreparedStatement statement = null;
		int id = -1;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
			statement.setString(1,professor.getEmail());
			statement.setString(2,password);
			statement.setString(3,professor.getRole());
			int rows = statement.executeUpdate();
			logger.info(rows + " added in User");
			
			statement = connection.prepareStatement(SQLQueriesConstants.FETCH_USER_ID);
			statement.setString(1, professor.getEmail());
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			rs.next();
			professor.setUserId(rs.getInt(1));
			id = professor.getUserId();
			
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR_QUERY);
			statement.setInt(1, professor.getUserId());
			statement.setString(2, professor.getDepartment());
			statement.setString(3, professor.getUsername());
			statement.setString(4, professor.getGender());
			statement.setString(5, professor.getAddress());
			rows = statement.executeUpdate();
			logger.info(rows + " added in Professor");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return id;
	}

	@Override
	public void assignProfessorToCourse(int professorId, int courseId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.ASSIGN_PROFESSOR_QUERY);
			statement.setInt(1, professorId);
			statement.setInt(2, courseId);
			int rows = statement.executeUpdate();
			logger.info(rows + "  professor courses updated");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			int rows;
			statement = connection.prepareStatement(SQLQueriesConstants.DELETE_USER_QUERY);
			statement.setInt(1, userId);
			rows = statement.executeUpdate();
			logger.info(rows + " deleted form Users Table");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public int addAdmin(Admin admin, String password) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		int id = -1;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
			statement.setString(1, admin.getEmail());
			statement.setString(2, password);
			statement.setString(3, admin.getRole());
			int rows = statement.executeUpdate();
			logger.info(rows + " added in User");
			
			statement = connection.prepareStatement(SQLQueriesConstants.FETCH_USER_ID);
			statement.setString(1, admin.getEmail());
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			rs.next();
			admin.setUserId(rs.getInt(1));
			id = admin.getUserId();
			
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_ADMIN_QUERY);
			statement.setInt(1, admin.getUserId());
			statement.setString(2, admin.getGender());
			statement.setString(3, admin.getAddress());
			statement.setString(4, admin.getUsername());
			rows = statement.executeUpdate();
			logger.info(rows + " added in Admin");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return id;
	}

	@Override
	public Admin getAdminDetails(int  userId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Admin admin = new Admin();
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_ADMIN_QUERY);
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			admin.setAdminId(rs.getInt(1));
			admin.setGender(rs.getString(2));
			admin.setAddress(rs.getString(3));
			admin.setUsername(rs.getString(4));
			
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return admin;
	}

	@Override
	public void addCatalog(int catalogId,String catalogName) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_NEW_CATALOG);
			statement.setInt(1, catalogId);
			statement.setString(2, catalogName);
			int rows = statement.executeUpdate();
			logger.info(rows + " catalog added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void removeCatalog(int catalogId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.DELETE_CATALOG);
			statement.setInt(1, catalogId);
			int rows = statement.executeUpdate();
			logger.info(rows + " catalog deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Override
	public void addCourseIntoCatalog(Course course, int catalogId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_NEW_COURSE_QUERY);
			statement.setInt(1, catalogId);
			statement.setInt(2, course.getCourseId());
			statement.setString(3, course.getCourseName());
			statement.setInt(4, course.getFees());
			statement.setString(5, course.getDescription());
			statement.setInt(6,course.getCapacity());
			int rows = statement.executeUpdate();
			logger.info(rows + " course added into catalog");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void removeCourseFromCatalog(int courseId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.DELETE_COURSE_QUERY);
			statement.setInt(1,courseId);
			int rows = statement.executeUpdate();
			logger.info(rows + " deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void addCourseToOffer(int courseId,int catalogId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_COURSE_TO_OFFERED_COURSE);
			statement.setInt(1, catalogId);
			statement.setInt(2, courseId);
			int rows = statement.executeUpdate();
			logger.info(rows + " added course into offered course");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void removeOfferedCourse(int courseId,int catalogId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.DELETE_OFFERED_COURSE);
			statement.setInt(1, catalogId);
			statement.setInt(2, courseId);
			
			int rows = statement.executeUpdate();
			logger.info(rows + " deleted from offered course");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}


	@Override
	public void approveStudent(int studentId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.APPROVE_STUDENT);
			statement.setInt(1, studentId);
			int rows = statement.executeUpdate();
			logger.info(rows + " approved student");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
}
