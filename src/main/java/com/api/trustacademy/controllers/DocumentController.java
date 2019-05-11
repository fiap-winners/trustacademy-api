package com.api.trustacademy.controllers;

import com.api.trustacademy.models.Document;
import com.api.trustacademy.models.Institute;
import com.api.trustacademy.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class DocumentController {

  private DocumentService documentService;
  private InstituteController instituteController;
  private CourseController courseController;

  @Autowired
  public DocumentController(DocumentService documentService, InstituteController instituteController, CourseController courseController) {
    this.documentService = documentService;
    this.instituteController = instituteController;
    this.courseController = courseController;
  }

  @GetMapping("institutes/{instituteId}/documents")
  public Set<Document> getInstituteDocuments(@PathVariable long instituteId) {
    Institute institute = instituteController.getInstitute(instituteId);
    return institute.getDocuments();
  }
}
