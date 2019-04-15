package com.api.trustacademy.repositories;

import com.api.trustacademy.models.DocumentType;
import com.api.trustacademy.projections.BasicDataPresenter;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = BasicDataPresenter.class)
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Long> {}
