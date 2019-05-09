package com.api.trustacademy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.trustacademy.models.Institute;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends CrudRepository<Institute, Long> {}
