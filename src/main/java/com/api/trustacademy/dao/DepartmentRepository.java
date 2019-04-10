package com.api.trustacademy.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {}
