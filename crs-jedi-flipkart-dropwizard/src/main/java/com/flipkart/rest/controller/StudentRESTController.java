package com.flipkart.rest.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

import org.apache.log4j.Logger;

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
        studentOperations.registerCourse(studentId, courseId);
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
    public ArrayList<Course> viewRegisteredCourses(@PathParam("studentId") int studentId) {
        return studentOperations.viewRegisteredCourses(studentId);
    }

    @GET
    @Path("view-grades/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<List> viewGrades(@PathParam("studentId") int studentId) {
        return studentOperations.viewGrades(studentId);
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

    @DELETE
    @Path("/drop-course/{studentId}/{courseId}")
    public Response dropCourse(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) {
        if(studentOperations.dropCourse(studentId, courseId)) {
            return Response.status(200).entity("The Course with CourseID: " + courseId + " for student: " + studentId + " has been successfully deleted.").build();
        } else {
            return Response.status(404).entity("The Course with CourseID: " + courseId + " for student: " + studentId + " does not exist.").build();
        }
    }
}
