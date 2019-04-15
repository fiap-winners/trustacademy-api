package com.api.trustacademy.repositories;

import com.api.trustacademy.projections.DepartmentDataPresenter;
import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Department;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = DepartmentDataPresenter.class)
public interface DepartmentRepository extends CrudRepository<Department, Long> {}
