package com.api.trustacademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.trustacademy.models.Course;
import com.api.trustacademy.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository repository;

	public List<Course> findAllCourses() {
		return repository.findAll();
	}

	public Optional<Course> findById(Long id) {
		return repository.findById(id);
	}

	public Course save(Course course) {
		return repository.save(course);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
