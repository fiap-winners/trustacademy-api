package com.api.trustacademy.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {}
