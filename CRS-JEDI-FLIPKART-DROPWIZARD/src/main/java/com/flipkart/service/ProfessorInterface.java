package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * Professor business interface
 */
public interface ProfessorInterface {

    /**
     * To view courses in CRS taught by the professor
     *
     * @param professorId unique identifier of the professor
     * @return 
     */
    List<Course> viewAssignedCourses(int professorId);

    /**
     * To view students enrolled in a course in CRS taught by professor
     *
     * @param professorId unique identifier of the professor of course
     * @param courseId    unique identifier of the course to view enrolled students
     * @return 
     */
    List<Student> viewStudentsRegisteredInCourse(int professorId, int courseId);

    /**
     * To grade a student in a course taught by professor
     *  @param professorId unique identifier of the professor grading the course
     * @param courseId    unique identifier of course for which student is graded
     * @param grade       grade assigned to student in a course by the professor
     * @param studentId   unique identifier of student to whom grade is assigned
     * @return
     */
    String gradeStudent(int professorId, int courseId, String grade, int studentId);
}