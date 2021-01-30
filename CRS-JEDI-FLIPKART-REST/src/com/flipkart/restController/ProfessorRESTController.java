package com.flipkart.restController;
 
import java.util.ArrayList;
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
import com.flipkart.helper.AssignGradeRequest;
import com.flipkart.service.ProfessorOperations;
import com.flipkart.service.StudentOperations;
  
/**
 * @author sankeerth
 *
 */
 
@Path("/professor")
public class ProfessorRESTController {
	
    ProfessorOperations professorOperation = ProfessorOperations.getInstance();
    StudentOperations studentOperations = StudentOperations.getInstance();
 
    @GET
    @Path("/viewprofessorcourses/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewAssignedCourses(@PathParam("professorId") int professorId) {
    	
    	return professorOperation.viewAssignedCourses(professorId);
    }
 
    @GET	
    @Path("/viewstudents/{professorId}/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Student> viewStudentsRegisteredInCourse(@PathParam("professorId") int professorId,@PathParam("courseId") int courseId) {
        return professorOperation.viewStudentsRegisteredInCourse(professorId,courseId);

    }
    
    @POST
    @Path("/grade-student")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response gradeStudent(AssignGradeRequest graderequest) {
    	professorOperation.gradeStudent(graderequest.getProfessorId(), graderequest.getCourseId(), graderequest.getGrade(), graderequest.getStudentId());
		//String str="{\"abc\":\"UUID abcSuccess\"}";
    	return Response.status(201).entity(studentOperations.viewGrades(graderequest.getStudentId())).build();

	}

    
    //    void gradeStudent(@PathParam("professorId") int professorId,
//			@PathParam("courseId") int courseId, @PathParam("grade") String grade, @PathParam("studentId") int studentId) {
//    	
//    }
 
	
 
}