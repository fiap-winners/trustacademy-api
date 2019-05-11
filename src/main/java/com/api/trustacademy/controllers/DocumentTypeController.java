package com.api.trustacademy.controllers;

import com.api.trustacademy.exceptions.DepartmentNotFoundException;
import com.api.trustacademy.exceptions.DocumentTypeNotFoundException;
import com.api.trustacademy.exceptions.InstituteNotFoundException;
import com.api.trustacademy.models.DocumentType;
import com.api.trustacademy.models.Institute;
import com.api.trustacademy.services.DocumentTypeService;
import com.api.trustacademy.services.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class DocumentTypeController {

  private InstituteService instituteService;
  private DocumentTypeService documentTypeService;

  @Autowired
  public DocumentTypeController(InstituteService instituteService, DocumentTypeService documentTypeService) {
    this.instituteService = instituteService;
    this.documentTypeService = documentTypeService;
  }

  @GetMapping("institutes/{instituteId}/document-types")
  public Set<DocumentType> getDocumentTypes(@PathVariable long instituteId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    return instituteOptional.get().getDocumentTypes();
  }

  @PostMapping("institutes/{instituteId}/document-types")
  public DocumentType createDocumentType(@PathVariable long instituteId, @RequestBody DocumentType documentType) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    documentType.setInstitute(instituteOptional.get());
    return documentTypeService.save(documentType);
  }

  @GetMapping("institutes/{instituteId}/document-types/{documentTypeId}")
  public DocumentType getDocumentType(@PathVariable long instituteId, @PathVariable long documentTypeId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<DocumentType> documentTypeOptional = documentTypeService.findById(documentTypeId);
    if (!documentTypeOptional.isPresent()) {
      throw new DocumentTypeNotFoundException("DocumentType with id " + documentTypeId + " not found");
    }

    return documentTypeOptional.get();
  }

  @PutMapping("institutes/{instituteId}/document-types/{documentTypeId}")
  public DocumentType updateDocumentType(@PathVariable long instituteId, @PathVariable long documentTypeId, @RequestBody DocumentType updates) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<DocumentType> documentTypeOptional = documentTypeService.findById(documentTypeId);
    if (!documentTypeOptional.isPresent()) {
      throw new DepartmentNotFoundException("DocumentType with id " + documentTypeId + " not found");
    }

    DocumentType documentType = documentTypeOptional.get();

    documentType.setName(updates.getName());
    documentType.setInstitute(instituteOptional.get());

    return documentTypeService.save(documentType);
  }

  @DeleteMapping("institutes/{instituteId}/document-types/{documentTypeId}")
  public DocumentType deleteDocumentType(@PathVariable long instituteId, @PathVariable long documentTypeId) {
    Optional<Institute> instituteOptional = instituteService.findById(instituteId);
    if (!instituteOptional.isPresent()) {
      throw new InstituteNotFoundException("Institute with id " + instituteId + " not found");
    }

    Optional<DocumentType> documentTypeOptional = documentTypeService.findById(documentTypeId);
    if (!documentTypeOptional.isPresent()) {
      throw new DepartmentNotFoundException("DocumentType with id " + documentTypeId + " not found");
    }

    documentTypeService.deleteById(documentTypeId);

    return documentTypeOptional.get();
  }
}
