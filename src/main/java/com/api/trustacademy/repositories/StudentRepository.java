package com.api.trustacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.trustacademy.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
