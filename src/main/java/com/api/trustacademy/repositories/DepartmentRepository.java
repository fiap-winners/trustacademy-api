package com.api.trustacademy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {}
