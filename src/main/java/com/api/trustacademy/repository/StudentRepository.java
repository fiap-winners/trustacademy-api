package com.api.trustacademy.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {}
