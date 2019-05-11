package com.api.trustacademy.controllers;

import com.api.trustacademy.exceptions.CourseNotFoundException;
import com.api.trustacademy.models.Course;
import com.api.trustacademy.models.Department;
import com.api.trustacademy.services.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@Api(tags="Course", description = "Manage the courses within an academic institute's department")
public class CourseController {

  private DepartmentController departmentController;
  private CourseService courseService;

  @Autowired
  public CourseController(DepartmentController departmentController, CourseService courseService) {
    this.departmentController = departmentController;
    this.courseService = courseService;
  }

  @GetMapping("institutes/{instituteId}/departments/{departmentId}/courses")
  public Set<Course> getCourses(@PathVariable long instituteId, @PathVariable long departmentId) {
    Department department = departmentController.getDepartment(instituteId, departmentId);
    return department.getCourses();
  }

  @PostMapping("institutes/{instituteId}/departments/{departmentId}/courses")
  public Course createCourse(@PathVariable long instituteId, @PathVariable long departmentId, @RequestBody Course course) {
    Department department = departmentController.getDepartment(instituteId, departmentId);
    course.setDepartment(department);
    return courseService.save(course);
  }

  @GetMapping("institutes/{instituteId}/departments/{departmentId}/courses/{courseId}")
  public Course getCourse(@PathVariable long instituteId, @PathVariable long departmentId, @PathVariable long courseId) {
    Department department = departmentController.getDepartment(instituteId, departmentId);

    CourseNotFoundException courseNotFoundException =
      new CourseNotFoundException("Course with id " + courseId + "not found");

    Optional<Course> courseOptional = courseService.findById(courseId);
    if (!courseOptional.isPresent()) {
      throw courseNotFoundException;
    }

    Course course = courseOptional.get();

    // IMPORTANT: ensure course actually belongs to department before returning it
    if (!course.getDepartment().getId().equals(department.getId())) {
      throw courseNotFoundException;
    }

    return course;
  }

  @PutMapping("institutes/{instituteId}/departments/{departmentId}/courses/{courseId}")
  public Course updateCourse(@PathVariable long instituteId, @PathVariable long departmentId, @PathVariable long courseId, @RequestBody Course updates) {
    Course course = getCourse(instituteId, departmentId, courseId);
    course.setName(updates.getName());
    return courseService.save(course);
  }

  @DeleteMapping("institutes/{instituteId}/departments/{departmentId}/courses/{courseId}")
  public Course deleteCourse(@PathVariable long instituteId, @PathVariable long departmentId, @PathVariable long courseId) {
    Course course = getCourse(instituteId, departmentId, courseId);

    courseService.deleteById(course.getId());

    return course;
  }

}
