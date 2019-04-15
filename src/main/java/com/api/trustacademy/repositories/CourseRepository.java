package com.api.trustacademy.repositories;

import com.api.trustacademy.projections.BasicDataPresenter;
import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Course;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = BasicDataPresenter.class)
public interface CourseRepository extends CrudRepository<Course, Long> {}
