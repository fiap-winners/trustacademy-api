package com.api.trustacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.trustacademy.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
