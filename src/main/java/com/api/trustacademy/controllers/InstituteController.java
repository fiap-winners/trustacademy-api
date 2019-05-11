package com.api.trustacademy.controllers;

import com.api.trustacademy.exceptions.InstituteNotFoundException;
import com.api.trustacademy.models.Institute;
import com.api.trustacademy.services.InstituteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(tags="Institute", description = "Manage an institute")
public class InstituteController {

  private InstituteService instituteService;

  @Autowired
  public InstituteController(InstituteService instituteService) {
    this.instituteService = instituteService;
  }

  @GetMapping("institutes/{instituteId}")
  public Institute getInstitute(@PathVariable long instituteId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);

    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    return instituteOptional.get();
  }

  @PutMapping("institutes/{instituteId}")
  public Institute getInstitute(@PathVariable long instituteId, @RequestBody Institute updates) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);

    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Institute institute = instituteOptional.get();

    institute.setName(updates.getName());
    institute.setCode(updates.getCode());

    return instituteService.save(institute);
  }
}
