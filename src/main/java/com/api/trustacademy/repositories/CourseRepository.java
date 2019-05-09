package com.api.trustacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.trustacademy.models.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
