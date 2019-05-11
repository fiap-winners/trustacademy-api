package com.api.trustacademy.controllers;

import java.util.Optional;
import java.util.Set;

import com.api.trustacademy.exceptions.StudentNotFoundException;
import com.api.trustacademy.models.Institute;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.trustacademy.models.Student;
import com.api.trustacademy.services.StudentService;

@RestController
@Api(tags="Student", description = "Manage the students of an academic institute")
public class StudentController {

  private StudentService studentService;
  private InstituteController instituteController;

  @Autowired
  public StudentController(StudentService studentService, InstituteController instituteController) {
    this.studentService = studentService;
    this.instituteController = instituteController;
  }

  @GetMapping("institutes/{instituteId}/students")
  public Set<Student> getStudents(@PathVariable long instituteId) {
    Institute institute = instituteController.getInstitute(instituteId);
    return institute.getStudents();
  }

  @PostMapping("institutes/{instituteId}/students")
  public Student createStudent(@PathVariable long instituteId, @RequestBody Student student) {
    Institute institute = instituteController.getInstitute(instituteId);
    student.setInstitute(institute);
    return studentService.save(student);
  }

  @GetMapping("institutes/{instituteId}/students/{studentId}")
  public Student getStudent(@PathVariable long instituteId, @PathVariable long studentId) {
    Institute institute = instituteController.getInstitute(instituteId);

    StudentNotFoundException studentNotFoundException =
      new StudentNotFoundException("Student with id " + studentId + " not found");

    Optional<Student> optionalStudent = studentService.findById(studentId);
    if (!optionalStudent.isPresent()) {
      throw studentNotFoundException;
    }

    Student student = optionalStudent.get();

    // IMPORTANT: ensure student actually belongs to institute before returning it
    if (!student.getInstitute().getId().equals(institute.getId())) {
      throw studentNotFoundException;
    }

    return student;
  }

  @PutMapping("institutes/{instituteId}/students/{studentId}")
  public Student updateStudent(@PathVariable long instituteId, @PathVariable long studentId, @RequestBody Student updates) {
    Student student = getStudent(instituteId, studentId);
    student.setName(updates.getName());
    return studentService.save(student);
  }

  @DeleteMapping("institutes/{instituteId}/students/{studentId}")
  public Student deleteStudent(@PathVariable Long instituteId, @PathVariable long studentId) {
    Student student = getStudent(instituteId, studentId);
    studentService.deleteById(studentId);
    return student;
  }
}
