package com.api.trustacademy.repositories;

import com.api.trustacademy.models.DocumentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Long> {
}
