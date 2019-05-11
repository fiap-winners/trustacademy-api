package com.api.trustacademy.controllers;

import com.api.trustacademy.exceptions.DepartmentNotFoundException;
import com.api.trustacademy.exceptions.InstituteNotFoundException;
import com.api.trustacademy.models.Department;
import com.api.trustacademy.models.Institute;
import com.api.trustacademy.services.DepartamentService;
import com.api.trustacademy.services.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class DepartmentController {

  private InstituteService instituteService;
  private DepartamentService departamentService;

  @Autowired
  public DepartmentController(InstituteService instituteService, DepartamentService departamentService) {
    this.instituteService = instituteService;
    this.departamentService = departamentService;
  }

  @GetMapping("institutes/{instituteId}/departments")
  public Set<Department> getDepartments(@PathVariable long instituteId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    return instituteOptional.get().getDepartments();
  }

  @PostMapping("institutes/{instituteId}/departments")
  public Department createDepartment(@PathVariable long instituteId, @RequestBody Department department) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    department.setInstitute(instituteOptional.get());
    return departamentService.save(department);
  }

  @GetMapping("institutes/{instituteId}/departments/{departmentId}")
  public Department getDepartment(@PathVariable long instituteId, @PathVariable long departmentId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<Department> departmentOptional = departamentService.findById(departmentId);
    if (!departmentOptional.isPresent()) {
      throw new DepartmentNotFoundException("Department with id " + departmentId + " not found");
    }

    return departmentOptional.get();
  }

  @PutMapping("institutes/{instituteId}/departments/{departmentId}")
  public Department updateDepartment(@PathVariable long instituteId, @PathVariable long departmentId, @RequestBody Department department) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<Department> departmentOptional = departamentService.findById(departmentId);
    if (!departmentOptional.isPresent()) {
      throw new DepartmentNotFoundException("Department with id " + departmentId + " not found");
    }

    department.setInstitute(instituteOptional.get());
    department.setId(departmentOptional.get().getId());

    return departamentService.save(department);
  }

  @DeleteMapping("institutes/{instituteId}/departments/{departmentId}")
  public Department deleteDepartment(@PathVariable long instituteId, @PathVariable long departmentId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<Department> departmentOptional = departamentService.findById(departmentId);
    if (!departmentOptional.isPresent()) {
      throw new DepartmentNotFoundException("Department with id " + departmentId + " not found");
    }

    departamentService.deleteById(departmentId);

    return departmentOptional.get();
  }

}
