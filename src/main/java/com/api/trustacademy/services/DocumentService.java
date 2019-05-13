package com.api.trustacademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.trustacademy.models.Document;
import com.api.trustacademy.repositories.DocumentRepository;

@Service
public class DocumentService {

  @Autowired
  DocumentRepository repository;

  public List<Document> findAll() {
    return repository.findAll();
  }

  public Optional<Document> findById(Long id) {
    return repository.findById(id);
  }

  public Document save(Document document) {
    return repository.save(document);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
