package com.api.trustacademy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.api.trustacademy.models.Document;
import com.api.trustacademy.projections.DocumentDataPresenter;

@RepositoryRestResource(excerptProjection = DocumentDataPresenter.class)
public interface DocumentRepository extends CrudRepository<Document, Long> {}
