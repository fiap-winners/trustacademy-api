package com.api.trustacademy.controllers;

import com.api.trustacademy.exceptions.DocumentNotFoundException;
import com.api.trustacademy.models.*;
import com.api.trustacademy.services.DocumentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@Api(tags="Document", description = "Access and create documents")
public class DocumentController {

  private DocumentService documentService;
  private DocumentTypeController documentTypeController;
  private InstituteController instituteController;
  private CourseController courseController;
  private StudentController studentController;

  @Autowired
  public DocumentController(
    DocumentService documentService,
    StudentController studentController,
    CourseController courseController,
    DocumentTypeController documentTypeController,
    InstituteController instituteController) {
    this.documentService = documentService;
    this.studentController = studentController;
    this.courseController = courseController;
    this.documentTypeController = documentTypeController;
    this.instituteController = instituteController;
  }

  @GetMapping("documents/{documentId}")
  public Document getDocumentById(@PathVariable long documentId) {
    Optional<Document> documentOptional = documentService.findById(documentId);

    if (!documentOptional.isPresent()) {
      throw new DocumentNotFoundException("Document with id " + documentId + " not found");
    }

    return documentOptional.get();
  }

  @GetMapping("institutes/{instituteId}/documents")
  public Set<Document> getInstituteDocuments(@PathVariable long instituteId) {
    Institute institute = instituteController.getInstitute(instituteId);
    return institute.getDocuments();
  }

  @GetMapping("institutes/{instituteId}/students/{studentId}/documents")
  public Set<Document> getStudentDocuments(@PathVariable long instituteId, @PathVariable long studentId) {
    Student student = studentController.getStudent(instituteId, studentId);
    return student.getDocuments();
  }

  @PostMapping("institutes/{instituteId}/departments/{departmentId}/courses/{courseId}/students/{studentId}/document-types/{documentTypeId}/documents")
  public Document createDocument(
    @PathVariable long instituteId, @PathVariable long departmentId,
    @PathVariable long courseId, @PathVariable long studentId,
    @PathVariable long documentTypeId, @RequestBody Document document) {
    Course course = courseController.getCourse(instituteId, departmentId, courseId);
    Student student = studentController.getStudent(instituteId, studentId);
    DocumentType documentType = documentTypeController.getDocumentType(instituteId, documentTypeId);

    document.setInstitute(student.getInstitute());
    document.setDepartment(course.getDepartment());
    document.setCourse(course);
    document.setStudent(student);
    document.setType(documentType);

    return documentService.save(document);
  }
}
