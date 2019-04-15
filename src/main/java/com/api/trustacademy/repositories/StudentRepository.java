package com.api.trustacademy.repositories;

import com.api.trustacademy.projections.BasicDataPresenter;
import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Student;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = BasicDataPresenter.class)
public interface StudentRepository extends CrudRepository<Student, Long> {}
