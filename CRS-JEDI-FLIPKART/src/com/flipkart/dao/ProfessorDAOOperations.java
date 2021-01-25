package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

public class ProfessorDAOOperations implements ProfessorDAOInterface {

	private static final Logger logger = Logger.getLogger(ProfessorDAOOperations.class);	
	static Connection connection = DBUtils.getConnection();
	
	private static volatile ProfessorDAOOperations instance = null;
	 
    // private constructor
    private ProfessorDAOOperations() {
    }
 
    public static ProfessorDAOOperations getInstance() {
        if (instance == null) {
        	// This is a synchronized block, when multiple threads will access this instance
            synchronized (ProfessorDAOOperations.class) {
                instance = new ProfessorDAOOperations();
            }
        }
        return instance;
    }
	
	public List<Student> getRegisteredStudentsInCourse(int userid, int courseId) {

		List<Student> students = new ArrayList<Student>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstants.GET_REGISTERED_STUDENTS);
			stmt.setInt(1, courseId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt(1));
				student.setUsername(rs.getString("name"));
				student.setBranch(rs.getString("branch"));
				students.add(student);
		
			}
		} catch (SQLException se){
			logger.error(se.getMessage());
		}
		return students;
		
		
	}

	public List<Course> getAssignedCourses (int userid){
		List<Course> courses=new ArrayList<Course>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstants.GET_ASSIGNED_COURSES);
			stmt.setInt(1, userid);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Course course=new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setFees(rs.getInt(3));
				course.setDescription(rs.getString(4));
				course.setCapacity(rs.getInt(5));
				courses.add(course);
			}
		} catch(SQLException se) {
			logger.error(se.getMessage());
		}
		return courses;
		
	}

	//TODO: implement data fetch using SQL queries
	public void gradeStudent(int courseId, int studentId, String grade) {
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstants.ASSIGN_GRADE);
			stmt.setString(1, grade);
			stmt.setInt(2,studentId);
			stmt.setInt(3, courseId);
			int rs = stmt.executeUpdate();
		} catch(SQLException se) {
			logger.error(se.getMessage());
		}
	}

	//TODO: implement data fetch using SQL queries
	@Override
	public boolean checkCanGradeCourse(int userid, int courseId) {
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstants.VALID_COURSE_FOR_PROFESSOR);
			stmt.setInt(1, userid);
			stmt.setInt(2, courseId);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return true;
			}
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}
		return false;
	}

	//TODO: implement data fetch using SQL queries
	@Override
	public boolean checkCanGradeStudent(int studentId, int courseId) {
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstants.VALID_COURSE_FOR_STUDENT);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}
		return false;
		
	}
	//TODO: implement data fetch using SQL queries
	@Override
	public Professor getProfessorDetails(int userid) {

		PreparedStatement stmt=null;
		Professor professor = new Professor();
		try {
			stmt=connection.prepareStatement(SQLQueriesConstants.PROFESSOR_DETAILS_QUERY);
			stmt.setInt(1, userid);
			ResultSet rs=stmt.executeQuery();
			rs.next();
				professor.setProfessorId(userid);
				professor.setDepartment(rs.getString(1));
				professor.setUsername(rs.getString(2));
				professor.setGender(rs.getString(3));
				professor.setAddress(rs.getString(4));
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}

		return professor;
	}


}
