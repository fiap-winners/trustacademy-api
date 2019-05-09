package com.api.trustacademy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Autowired
	StudentService service;

	@GetMapping("/students")
	List<Student> getAllStudents() {
		return service.findAll();
	}
	
	@PostMapping("/students")
	Student createStudent(@RequestBody Student student) {
		return service.save(student);
	}

	@GetMapping("/students/{id}")
	ResponseEntity<Student> getStudent(@PathVariable long id) {
		Optional<Student> student = service.findById(id);

		if (!student.isPresent())
			return ResponseEntity.notFound().build();

		return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{id}")
	void deleteStudent(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/students/{id}")
	ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable long id) {

		Optional<Student> studentOptional = service.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		service.save(student);
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}
