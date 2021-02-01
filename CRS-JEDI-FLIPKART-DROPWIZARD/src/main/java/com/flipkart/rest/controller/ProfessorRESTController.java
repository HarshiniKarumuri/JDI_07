package com.flipkart.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.ProfessorOperations;
import com.flipkart.service.StudentOperations;

@Path("/professor")
public class ProfessorRESTController {

    private final ProfessorOperations professorOperation = ProfessorOperations.getInstance();
    private final StudentOperations studentOperations = StudentOperations.getInstance();

    @GET
    @Path("/view-professor-courses/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewAssignedCourses(@PathParam("professorId") int professorId) {
        return professorOperation.viewAssignedCourses(professorId);
    }

    @GET
    @Path("/view-students/{professorId}/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> viewStudentsRegisteredInCourse(@PathParam("professorId") int professorId, @PathParam("courseId") int courseId) {
        return professorOperation.viewStudentsRegisteredInCourse(professorId, courseId);

    }

    @POST
    @Path("/grade-student/{professorId}/{courseId}/{studentId}/{grade}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gradeStudent(@PathParam("professorId") int professorId, @PathParam("courseId") int courseId, @PathParam("grade") String grade, @PathParam("studentId") int studentId) {
        professorOperation.gradeStudent(professorId, courseId, grade, studentId);
        return Response.status(201).entity(studentOperations.viewGrades(studentId)).build();
    }


}