package com.api.trustacademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.trustacademy.models.Institute;
import com.api.trustacademy.repositories.InstituteRepository;

@Service
public class InstituteService {

	@Autowired
	InstituteRepository repository;

	public List<Institute> findAll() {
		return repository.findAll();
	}

	public Optional<Institute> findById(Long id) {
		return repository.findById(id);
	}

	public Institute save(Institute institute) {
		return repository.save(institute);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
