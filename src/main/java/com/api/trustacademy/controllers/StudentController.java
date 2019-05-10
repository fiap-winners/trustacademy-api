package com.api.trustacademy.controllers;

import java.util.Optional;
import java.util.Set;

import com.api.trustacademy.exceptions.InstituteNotFoundException;
import com.api.trustacademy.exceptions.StudentNotFoundException;
import com.api.trustacademy.models.Institute;
import com.api.trustacademy.services.InstituteService;
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
public class StudentController {

	private StudentService studentService;
	private InstituteService instituteService;

	@Autowired
  public StudentController(StudentService studentService, InstituteService instituteService) {
    this.studentService = studentService;
    this.instituteService = instituteService;
  }

  @GetMapping("institutes/{instituteId}/students")
	public Set<Student> getStudents(@PathVariable long instituteId) {
		Optional<Institute> instituteOptional = instituteService.findById(instituteId);
		if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    return instituteOptional.get().getStudents();
	}

	@PostMapping("institutes/{instituteId}/students")
  public Student createStudent(@PathVariable long instituteId, @RequestBody Student student) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    student.setInstitute(instituteOptional.get());

    return studentService.save(student);
  }

	@GetMapping("institutes/{instituteId}/students/{studentId}")
	public Student getStudent(@PathVariable long instituteId, @PathVariable long studentId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<Student> optionalStudent = studentService.findById(studentId);
    if (!optionalStudent.isPresent()) {
      throw new StudentNotFoundException("Student with id " + studentId + " not found");
    }

		return optionalStudent.get();
	}
	
	@DeleteMapping("institutes/{instituteId}/students/{studentId}")
	public Student deleteStudent(@PathVariable Long instituteId, @PathVariable long studentId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<Student> optionalStudent = studentService.findById(studentId);
    if (!optionalStudent.isPresent()) {
      throw new StudentNotFoundException("Student with id " + studentId + " not found");
    }

    studentService.deleteById(studentId);
    return optionalStudent.get();
	}
	
	@PutMapping("institutes/{instituteId}/students/{studentId}")
	public Student updateStudent(@PathVariable long instituteId, @PathVariable long studentId, @RequestBody Student student) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<Student> optionalStudent = studentService.findById(studentId);
    if (!optionalStudent.isPresent()) {
      throw new StudentNotFoundException("Student with id " + studentId + " not found");
    }

    student.setInstitute(instituteOptional.get());
    student.setId(studentId);
    return studentService.save(student);
	}
}
