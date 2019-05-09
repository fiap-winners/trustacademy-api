package com.api.trustacademy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
