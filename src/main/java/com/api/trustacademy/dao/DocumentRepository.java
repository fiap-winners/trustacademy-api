package com.api.trustacademy.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {}
