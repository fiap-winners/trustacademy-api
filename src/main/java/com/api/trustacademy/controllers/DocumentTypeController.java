package com.api.trustacademy.controllers;

import com.api.trustacademy.exceptions.DocumentTypeNotFoundException;
import com.api.trustacademy.models.DocumentType;
import com.api.trustacademy.models.Institute;
import com.api.trustacademy.services.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class DocumentTypeController {

  private InstituteController instituteController;
  private DocumentTypeService documentTypeService;

  @Autowired
  public DocumentTypeController(InstituteController instituteController, DocumentTypeService documentTypeService) {
    this.instituteController = instituteController;
    this.documentTypeService = documentTypeService;
  }

  @GetMapping("institutes/{instituteId}/document-types")
  public Set<DocumentType> getDocumentTypes(@PathVariable long instituteId) {
    Institute institute = instituteController.getInstitute(instituteId);
    return institute.getDocumentTypes();
  }

  @PostMapping("institutes/{instituteId}/document-types")
  public DocumentType createDocumentType(@PathVariable long instituteId, @RequestBody DocumentType documentType) {
    Institute institute = instituteController.getInstitute(instituteId);
    documentType.setInstitute(institute);
    return documentTypeService.save(documentType);
  }

  @GetMapping("institutes/{instituteId}/document-types/{documentTypeId}")
  public DocumentType getDocumentType(@PathVariable long instituteId, @PathVariable long documentTypeId) {
    Institute institute = instituteController.getInstitute(instituteId);

    DocumentTypeNotFoundException documentTypeNotFoundException =
      new DocumentTypeNotFoundException("DocumentType with id " + documentTypeId + " not found");

    Optional<DocumentType> documentTypeOptional = documentTypeService.findById(documentTypeId);
    if (!documentTypeOptional.isPresent()) {
      throw documentTypeNotFoundException;
    }

    DocumentType documentType = documentTypeOptional.get();

    // IMPORTANT: ensure documentType actually belongs to institute before returning it
    if (!documentType.getInstitute().getId().equals(institute.getId())) {
      throw documentTypeNotFoundException;
    }

    return documentType;
  }

  @PutMapping("institutes/{instituteId}/document-types/{documentTypeId}")
  public DocumentType updateDocumentType(@PathVariable long instituteId, @PathVariable long documentTypeId, @RequestBody DocumentType updates) {
    DocumentType documentType = getDocumentType(instituteId, documentTypeId);
    documentType.setName(updates.getName());
    return documentTypeService.save(documentType);
  }

  @DeleteMapping("institutes/{instituteId}/document-types/{documentTypeId}")
  public DocumentType deleteDocumentType(@PathVariable long instituteId, @PathVariable long documentTypeId) {
    DocumentType documentType = getDocumentType(instituteId, documentTypeId);
    documentTypeService.deleteById(documentType.getId());
    return documentType;
  }
}
