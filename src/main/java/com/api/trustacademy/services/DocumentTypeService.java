package com.api.trustacademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.trustacademy.models.DocumentType;
import com.api.trustacademy.repositories.DocumentTypeRepository;

@Service
public class DocumentTypeService {

	@Autowired
	DocumentTypeRepository repository;

	public List<DocumentType> findAll() {
		return repository.findAll();
	}

	public Optional<DocumentType> findById(Long id) {
		return repository.findById(id);
	}

	public DocumentType save(DocumentType documentType) {
		return repository.save(documentType);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
