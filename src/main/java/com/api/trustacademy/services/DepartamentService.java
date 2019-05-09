package com.api.trustacademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.trustacademy.models.Department;
import com.api.trustacademy.repositories.DepartmentRepository;

@Service
public class DepartamentService {

	@Autowired
	DepartmentRepository repository;

	public List<Department> findAll() {
		return repository.findAll();
	}

	public Optional<Department> findById(Long id) {
		return repository.findById(id);
	}

	public Department save(Department department) {
		return repository.save(department);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
