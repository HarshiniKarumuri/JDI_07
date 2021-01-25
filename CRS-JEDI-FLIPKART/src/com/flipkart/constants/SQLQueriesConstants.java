package com.flipkart.constants;

/**
 * final queries for SQL database
 */
public class SQLQueriesConstants {
	
	//login and course catalog Query
	public static String LOGIN_QUERY = "SELECT u.role FROM User u WHERE u.user_id=?";
	public static String CHECK_CREDENTIALS_QUERY = "SELECT u.password FROM User u WHERE u.user_id=?";
	public static String VIEW_COURSES_QUERY = "SELECT * FROM CoursesCatalog";
	public static String VIEW_CATALOG_QUERY = "SELECT * FROM CoursesCatalog WHERE course_id = ?";
	
	//Professor Query 
	public static String PROFESSOR_DETAILS_QUERY ="select * from Professor where professor_id = ?";
	public static String VALID_COURSE_FOR_PROFESSOR="select professor_id from ProfessorCourse where professor_id=? and course_id=?";
	public static String VALID_COURSE_FOR_STUDENT="select student_id from RegisteredCourse where student_id=? and course_id=?";
	public static String GET_ASSIGNED_COURSES="select CoursesCatalog.course_id, CoursesCatalog.course_name, CoursesCatalog.fees ,CoursesCatalog.description,CoursesCatalog.capacity from ProfessorCourse join CoursesCatalog on CoursesCatalog.course_id = ProfessorCourse.course_id where ProfessorCourse.professor_id = ?";
	public static String GET_REGISTERED_STUDENTS="select * from Student join RegisteredCourse on RegisteredCourse.student_id = Student.student_id where RegisteredCourse.course_id = ?";
	public static String ASSIGN_GRADE="update RegisteredCourse set grade = ? where student_id = ? and course_id = ?";

	//Admin Query
	public static String VIEW_USERS_QUERY = "Select * from User";
	public static String ADD_USER_QUERY = "insert into User(email,password,role) values (?,?,?)";
	public static String DELETE_USER_QUERY = "delete from User where user_id = ?";
	public static String FETCH_ROLE_FROM_USER_ID = "select role form User where user_id = ?";
	public static String ADD_PROFESSOR_QUERY = "insert into Professor(professor_id,department,name,gender,address) values (?,?,?,?,?)";
	public static String DELETE_PROFESSOR_QUERY = "delete from Professor where professor_id = ?";
	public static String ASSIGN_PROFESSOR_QUERY = "insert into ProfessorCourse(professor_id,course_id) values (?, ?)";
	public static String DELETE_STUDENT_QUERY = "delete from Student where student_id = ?";
	public static String ADD_ADMIN_QUERY = "insert into Admin(admin_id,gender,address,name) values (?,?,?,?)";
	public static String DELETE_ADMIN_QUERY = "delete from Admin where admin_id = ?";
	public static String VIEW_ADMIN_QUERY = "select * from Admin where admin_id = ?";
	public static String ADD_NEW_CATALOG = "insert into Catalog(catalog_id,catalog_name) values(?,?)";
	public static String DELETE_CATALOG = "delete from Catalog where catalog_id = ?";
	public static String ADD_NEW_COURSE_QUERY = "insert into CoursesCatalog(catalog_id,course_id, course_name, fees, description, capacity) values (?,?,?,?,?,?)";
	public static String DELETE_COURSE_QUERY = "delete from CoursesCatalog where course_id = ?";
	public static String ADD_COURSE_TO_OFFERED_COURSE = "insert into CoursesOffered(catalog_id,course_id) values(?,?)";
	public static String DELETE_OFFERED_COURSE = "delete from CoursesOffered where catalog_id = ? and course_id = ?";
	public static String SEND_NOTIFICATION = "insert into Notification(student_id,description,timestamp) values (?,?,?)";
	public static String GET_NOTIFICATION = "select * from Notification where student_id = ?";
	public static String FETCH_USER_ID = "select user_id from User where email = ? and password = ?";
	public static String APPROVE_STUDENT = "update Student set is_approved = 1 where student_id = ?";
	
}
