package com.flipkart.rest.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Student;
import com.flipkart.constants.UIConstants;
import com.flipkart.exception.*;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperations;

@Path("/student")
public class StudentRESTController {

    private final StudentInterface studentOperations = StudentOperations.getInstance();
    
    @POST
    @Path("/register-course/{studentId}/{courseId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerCourse(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) {
        try {
            studentOperations.registerCourse(studentId, courseId);
        } catch (CourseNotFoundException | CourseNotRegisteredException | CourseAlreadyRegisteredException | CourseNotAvailableException | MaximumCourseRegisteredException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
        return Response.status(201).entity(studentOperations.viewRegisteredCourses(studentId)).build();
    }
    
    @POST
    @Path("/make-payment/{studentId}/{payMode}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response makePayment(@PathParam("studentId") int studentId, @PathParam("payMode") int payMode) {
        Payment payment = studentOperations.makePayment(studentId, payMode);
        int paymentId = payment.getPaymentId();
        int feesPaid = payment.getFeesPaid();
        String paymentMode = payment.getPaymentMode();
        Timestamp paymentTime = payment.getPaymentTime();
        Map<String, String> map = new HashMap<>();
        map.put("paymentId", Integer.toString(paymentId));
        map.put("feesPaid", Integer.toString(feesPaid));
        map.put("paymentMode", paymentMode);
        map.put("paymentTime", paymentTime.toString());
        map.put("studentId", Integer.toString(studentId));
//                + "payment was made by the student with student id: "+ studentId;
        return Response.status(201).entity(map).build();
    }
    
    @GET
    @Path("view-registered-courses/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewRegisteredCourses(@PathParam("studentId") int studentId) {
        List<Course> courses = studentOperations.viewRegisteredCourses(studentId);
        if(courses.size() == 0) {
            return Response.status(200).entity(UIConstants.NO_COURSE_REGISTERED_MESSAGE).build();
        }
        return Response.status(200).entity(courses).build();
    }

    @GET
    @Path("view-grades/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGrades(@PathParam("studentId") int studentId) {
        List<List> grades = studentOperations.viewGrades(studentId);
        if(grades.size() == 0) {
            return Response.status(200).entity(UIConstants.NO_COURSE_REGISTERED_MESSAGE).build();
        }
        return Response.status(200).entity(grades).build();
    }

    @GET
    @Path("/check-approval/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkApproval(@PathParam("studentId") int studentId) {
        if(studentOperations.isStudentProfileApproved(studentId)) {
            return "Your Profile is Approved";
        } else {
            return "Your Profile has not been approved";
        }
    }

    @POST
    @Path("/add-student")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(@Valid Student student) {
        StudentOperations studentOperations = StudentOperations.getInstance();
        try {
            int userId = studentOperations.addStudent(student);
            return Response.status(201).entity(UIConstants.SUCCESS_USER_ID_MESSAGE + userId).build();
        } catch (RegistrationFailedException | AlreadyRegisteredUserException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/drop-course/{studentId}/{courseId}")
    public Response dropCourse(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) {
        try {
            studentOperations.dropCourse(studentId, courseId);
        } catch (CourseNotFoundException | CourseNotRegisteredException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
        return Response.status(200).entity("The Course with CourseID: " + courseId + " for student: " + studentId + " has been successfully deleted.").build();
    }
}
