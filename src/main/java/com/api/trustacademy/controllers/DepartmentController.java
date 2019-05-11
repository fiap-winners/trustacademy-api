package com.api.trustacademy.controllers;

import com.api.trustacademy.exceptions.DepartmentNotFoundException;
import com.api.trustacademy.models.Department;
import com.api.trustacademy.models.Institute;
import com.api.trustacademy.services.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class DepartmentController {

  private InstituteController instituteController;
  private DepartamentService departamentService;

  @Autowired
  public DepartmentController(InstituteController instituteController, DepartamentService departamentService) {
    this.instituteController = instituteController;
    this.departamentService = departamentService;
  }

  @GetMapping("institutes/{instituteId}/departments")
  public Set<Department> getDepartments(@PathVariable long instituteId) {
    Institute institute = instituteController.getInstitute(instituteId);
    return institute.getDepartments();
  }

  @PostMapping("institutes/{instituteId}/departments")
  public Department createDepartment(@PathVariable long instituteId, @RequestBody Department department) {
    Institute institute = instituteController.getInstitute(instituteId);
    department.setInstitute(institute);
    return departamentService.save(department);
  }

  @GetMapping("institutes/{instituteId}/departments/{departmentId}")
  public Department getDepartment(@PathVariable long instituteId, @PathVariable long departmentId) {
    Institute institute = instituteController.getInstitute(instituteId);

    DepartmentNotFoundException departmentNotFoundException =
      new DepartmentNotFoundException("Department with id " + departmentId + " not found");

    Optional<Department> departmentOptional = departamentService.findById(departmentId);
    if (!departmentOptional.isPresent()) {
      throw departmentNotFoundException;
    }

    Department department = departmentOptional.get();

    // IMPORTANT: ensure department actually belongs to institute before returning it
    if (!department.getInstitute().getId().equals(institute.getId())) {
      throw departmentNotFoundException;
    }

    return department;
  }

  @PutMapping("institutes/{instituteId}/departments/{departmentId}")
  public Department updateDepartment(@PathVariable long instituteId, @PathVariable long departmentId, @RequestBody Department updates) {
    Department department = getDepartment(instituteId, departmentId);
    department.setName(updates.getName());
    department.setCode(updates.getCode());

    return departamentService.save(department);
  }

  @DeleteMapping("institutes/{instituteId}/departments/{departmentId}")
  public Department deleteDepartment(@PathVariable long instituteId, @PathVariable long departmentId) {
    Department department = getDepartment(instituteId, departmentId);
    departamentService.deleteById(departmentId);
    return department;
  }

}
