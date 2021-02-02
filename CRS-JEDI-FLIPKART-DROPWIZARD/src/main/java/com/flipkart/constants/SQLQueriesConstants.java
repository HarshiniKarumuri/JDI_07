package com.flipkart.constants;

/**
 * final queries for SQL database
 */
public class SQLQueriesConstants {

	//login and course catalog Query
	public static String LOGIN_QUERY = "SELECT u.role FROM User u WHERE u.user_id=?";
	public static String CHECK_CREDENTIALS_QUERY = "SELECT u.password FROM User u WHERE u.user_id=?";
	public static String VIEW_COURSES_QUERY = "SELECT * FROM CoursesCatalog";
	public static String VIEW_OFFERED_COURSE = "SELECT co.course_id, c.course_name, c.description, c.capacity, c.fees FROM CoursesOffered co JOIN CoursesCatalog c ON co.course_id = c.course_id";
	public static String VIEW_CATALOG_QUERY = "SELECT * FROM CoursesCatalog WHERE course_id = ?";

	//Student Query
	public static final String COUNT_STUDENT_REGISTERED_IN_COURSE = "select count(*) from RegisteredCourse where course_id = ?";
	public static String CHECK_EMAIL_EXIST_QUERY = "select count(*) from User where email = ?";
	public static  String MAKE_PAYMENT_QUERY = "insert into Payment(student_id, fees_paid, payment_mode) values(?, ?, ?);";
	public static  String UPDATE_AFTER_PAYMENT = "";
	public static  String ADD_COURSE_STUDENT_QUERY = "insert into RegisteredCourse(student_id, course_id) values(?,?)";
	public static  String VIEW_STUDENT_QUERY = "select * from Student where student_id = ?";
	public static  String GET_REGISTERED_COURSES_QUERY = "select course_id from RegisteredCourse where student_id = ?";
	public static  String VIEW_GRADES_QUERY = "select course_id, grade from RegisteredCourse where student_id = ?";
	public static  String CALCULATE_TOTAL_FEE = "select sum(cc.fees) from CoursesCatalog cc where cc.course_id in (select rc.course_id from RegisteredCourse rc where rc.student_id = ?)";
	public static  String DROP_COURSE_STUDENT_QUERY = "delete from RegisteredCourse where course_id = ? and student_id = ?";
	public static  String CHECK_COURSE_OFFERED_QUERY = "select count(*) from CoursesOffered where course_id = ?";
	public static  String VIEW_COURSE_QUERY = "select * from CoursesCatalog where course_id = ?";
	public static  String COUNT_REGISTERED_COURSES_QUERY = "select count(*) from RegisteredCourse where student_id = ?";
	public static  String CHECK_IF_REGISTERED_TO_COURSE_QUERY = "select count(*) from RegisteredCourse where student_id = ? and course_id = ?";
	public static String ADD_STUDENT = "insert into Student(student_id,branch,has_scholarship,is_approved,name,gender,address) values (?,?,?,?,?,?,?)";
	public static String IS_STUDENT_APPROVED = "select is_approved from Student where student_id = ?";
	public static String GET_LATEST_PAYMENT_DETAILS = "select * from Payment where student_id = ? ORDER BY payment_time DESC limit 1";

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
	public static String SEND_NOTIFICATION = "insert into Notification(student_id,description) values (?,?)";
	public static String GET_NOTIFICATION = "select * from Notification where student_id = ?";
	public static String FETCH_USER_ID = "select user_id from User where email = ? and password = ?";
	public static String APPROVE_STUDENT = "update Student set is_approved = true where student_id = ?";
	public static String VIEW_PENDING_APPROVAL_STUDENT = "select * from Student where is_approved = 0";
}
