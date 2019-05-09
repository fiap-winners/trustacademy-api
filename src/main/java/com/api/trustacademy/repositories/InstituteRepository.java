package com.api.trustacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.trustacademy.models.Institute;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long> {
}
