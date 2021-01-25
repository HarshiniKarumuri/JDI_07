package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

/**
 * Admin business interface
 */
public interface AdminInterface {

    /**
     * To see the list of users in CRS
     */
    void viewUser();

    /**
     * Register a professor user into CRS
     *
     * @param professor represents a new professor to be added into DB
     * @param password  password for professor account
     */
    void addProfessor(Professor professor, String password);

    /**
     * Assign a professor to a course offered
     *
     * @param professorId professor who is assigned a course
     * @param courseId    unique identifier of course
     */
    void assignProfessorToCourse(int professorId, int courseId);

    /**
     * Register a admin user in CRS
     *
     * @param admin    admin object which is added into DB
     * @param password password for professor account
     */
    void addAdmin(Admin admin, String password);

    /**
     * Delete an existing account of a user in CRS
     *
     * @param userId unique identifier of user to be deleted
     */
    void deleteUser(int userId);

    /**
     * To view the offered courses from courses catalog
     */
    void viewCoursesOffered();

    /**
     * Adds a new catalog
     *
     * @param catalogId   unique identifier of catalog
     * @param catalogName catalog name
     */
    void addCatalog(int catalogId, String catalogName);

    /**
     * Remove a catalog
     *
     * @param catalogId unique catalog identifier
     */
    void removeCatalog(int catalogId);

    /**
     * Adds a new course into catalog
     *
     * @param course    a new course to add into catalog
     * @param catalogId unique catalog identifier
     */
    void addCourseIntoCatalog(Course course, int catalogId);

    /**
     * Removes a course from catalog
     *
     * @param courseId a unique course identifier
     */
    void removeCourseFromCatalog(int courseId);

    /**
     * Remove an offered course
     *
     * @param courseId  course to add into offered Courses
     * @param catalogId unique identifier for catalog
     */
    void addCourseToOffer(int courseId, int catalogId);

    /**
     * @param courseId  unique identifier of the course to be removed from offered courses
     * @param catalogId unique identifier for catalog
     */
    void removeOfferedCourse(int courseId, int catalogId);

    /**
     * Approve Students
     *
     * @param studentId unique course identifier
     */
    void approveStudent(int studentId);
}
