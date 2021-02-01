package com.flipkart.rest.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.service.AdminOperations;
import com.flipkart.service.CourseCatalogOperations;
import com.flipkart.service.NotificationOperations;

@Path("/admin")
public class AdminRESTController {

	private final AdminOperations adminOperations = AdminOperations.getInstance();
	private final CourseCatalogOperations coursecatalogOperations = CourseCatalogOperations.getInstance();
	private final NotificationOperations notificationOperations=NotificationOperations.getInstance();

	@GET
	@Path("/view-users")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> viewUser() {
		return adminOperations.viewUser();
	}

	@GET
	@Path("/view-pending-approval-student")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> viewPendingApprovalStudent() {
		return adminOperations.viewPendingApprovalStudent();
	}

	@POST
	@Path("/add-professor")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(@Valid Professor professor) throws ValidationException {
		professor.setRole("Professor");
		int professorId = adminOperations.addProfessor(professor, professor.getPassword());
		String result;
		if (professorId != -1) {
			result = "Your User Id is " + professorId;
		} else {
			result = "Registration Failed";
		}
		return Response.status(201).entity(result).build();
	}

	@POST
	@Path("/assign-professor/{professorId}/{courseId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignProfessorToCourse(@PathParam("professorId") int professorId, @PathParam("courseId") int courseId) {
		adminOperations.assignProfessorToCourse(professorId, courseId);
		String result = "Professor Id " + professorId + " is assigned to course " + courseId + " succesfully.";
		return Response.status(201).entity(result).build();
	}

	@DELETE
	@Path("/delete-user/{userId}")
	public Response deleteUser(@PathParam("userId") int userId) {
		adminOperations.deleteUser(userId);
		String result = "User " + userId + " deleted Succesfully.";
		return Response.status(201).entity(result).build();
	}

	@POST
	@Path("/add-admin")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAdmin(@Valid Admin admin) throws ValidationException {
		admin.setRole("Admin");
		int adminId = adminOperations.addAdmin(admin, admin.getPassword());
		String result;
		if (adminId != -1) {
			result = "Your User Id is " + adminId;
		} else {
			result = "Registration Failed";
		}
		return Response.status(201).entity(result).build();
	}

	@GET
	@Path("/courses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> viewCoursesOffered() {
		List<Course> courses;
		courses = coursecatalogOperations.viewCoursesOffered();
		return courses;
	}

	@POST
	@Path("/add-catalog/{catalogId}/{catalogName}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCatalog(@PathParam("catalogId") int catalogId, @PathParam("catalogName") String catalogName) {
		int catalogid = adminOperations.addCatalog(catalogId, catalogName);
		String result;
		if (catalogId != -1) {
			result = "Catalog Id is " + catalogid;
		} else {
			result = "Addition Failed";
		}
		return Response.status(201).entity(result).build();
	}

	@DELETE
	@Path("/delete-catalog/{catalogId}")
	public Response removeCatalog(@PathParam("catalogId") int catalogId) {

		adminOperations.removeCatalog(catalogId);
		String result = "Catalog " + catalogId + " deleted Successfully.";
		return Response.status(201).entity(result).build();
	}

	@POST
	@Path("/add-course-to-catalog")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourseIntoCatalog(@Valid Course course) throws ValidationException {
		int catalogid = adminOperations.addCourseIntoCatalog(course, course.getCatalogId());
		ArrayList<Course> courses = coursecatalogOperations.viewCoursesCatalog();
		return Response.status(201).entity(courses).build();
	}

	@DELETE
	@Path("/remove-course-from-catalog/{courseId}")
	public Response removeCourseFromCatalog(@PathParam("courseId") int courseId) {
		adminOperations.removeCourseFromCatalog(courseId);
		String result = "Course " + courseId + " deleted Succesfully.";
		return Response.status(201).entity(result).build();
	}

	@POST
	@Path("/add-course-to-offer/{courseId}/{catalogId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourseToOffer(@PathParam("courseId") int courseId, @PathParam("catalogId") int catalogId) {
		adminOperations.addCourseToOffer(courseId, catalogId);
		//int courseid = adminOperations.addCourseToOffer(courseId, catalogId);
		return Response.status(201).entity(coursecatalogOperations.viewCoursesOffered()).build();
	}

	@DELETE
	@Path("/remove-course-from-offer/{courseId}/{catalogId}")
	public Response removeOfferedCourse(@PathParam("courseId") int courseId, @PathParam("catalogId") int catalogId) {
		adminOperations.removeOfferedCourse(courseId, catalogId);
		String result = "Course " + courseId + " deleted Succesfully.";
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/approve-student/{studentId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response approveStudent(@PathParam("studentId") int studentId) {
		int studentid=adminOperations.approveStudent(studentId);
		String result;
		if (studentid != -1) {
			result = "Student  " + studentid + " approved successfully";
		} else {
			result = "Approval Failed";
		}
		
		Notification notification = new Notification();
		notification.setUserId(studentId);
		notification.setTimestamp(new Timestamp(System.currentTimeMillis()));
		notification.setDescription(studentId + " profile is approved so kindly verify it.");
		notificationOperations.sendNotification(notification);
		
		return Response.status(201).entity(result).build();
	}

}