package com.flipkart.restController;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperations;

@Path("/studentRestController")
public class StudentRESTController {

    //private static final Logger logger = Logger.getLogger(StudentOperations.class);

    private final StudentInterface studentOperations = StudentOperations.getInstance();
//    private final NotificationOperations notificationOperations = NotificationOperations.getInstance();

    //    private static volatile StudentOperations instance = null;
//    @POST
//    @Path("/registerCourses")
//    @Produces(MediaType.APPLICATION_JSON)
//    public void registerCourse(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) {
//        try {
//            studentDAOOperations.registerCourse(studentId, courseId);
//            logger.info(UIConstants.SUCCESS_COURSE_REGISTER_MESSAGE);
//        } catch (CourseNotAvailableException | CourseNotFoundException | CourseAlreadyRegisteredException | CourseNotRegisteredException | MaximumCourseRegisteredException e) {
//            logger.error(e.getMessage());
//        }
//    }
    @GET
    @Path("viewRegisteredCourses/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Course> viewRegisteredCourses(@PathParam("studentId") int studentId) {

        ArrayList<Course> courses = studentOperations.viewRegisteredCourses(studentId);
        return courses;
    }

    @GET
    @Path("viewGrades/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<List> viewGrades(@PathParam("studentId") int studentId) {
        return studentOperations.viewGrades(studentId);
    }

    @GET
    @Path("/sample/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int sampleFunction(@PathParam("id") int id) {
        return id;
    }
}