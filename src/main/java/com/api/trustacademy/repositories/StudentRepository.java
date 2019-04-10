package com.api.trustacademy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {}
