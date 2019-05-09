package com.api.trustacademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.trustacademy.models.Student;
import com.api.trustacademy.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public List<Student> findAllStudents() {
		return repository.findAll();
	}

	public Optional<Student> findById(Long id) {
		return repository.findById(id);
	}

	public Student save(Student student) {
		return repository.save(student);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
