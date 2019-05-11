package com.api.trustacademy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.GregorianCalendar;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
    GlobalExceptionResponse globalExceptionResponse = GlobalExceptionResponse.builder()
      .timestamp(new GregorianCalendar())
      .message(ex.getMessage())
      .details(req.getDescription(false)).build();

    return new ResponseEntity<>(globalExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(InstituteNotFoundException.class)
  public final ResponseEntity<Object> handleInstituteNotFoundException(InstituteNotFoundException ex, WebRequest req) {
    GlobalExceptionResponse globalExceptionResponse = GlobalExceptionResponse.builder()
      .timestamp(new GregorianCalendar())
      .message(ex.getMessage())
      .details(req.getDescription(false)).build();

    return new ResponseEntity<>(globalExceptionResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(StudentNotFoundException.class)
  public final ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest req) {
    GlobalExceptionResponse globalExceptionResponse = GlobalExceptionResponse.builder()
      .timestamp(new GregorianCalendar())
      .message(ex.getMessage())
      .details(req.getDescription(false)).build();

    return new ResponseEntity<>(globalExceptionResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DepartmentNotFoundException.class)
  public final ResponseEntity<Object> handleDepartmentNotFoundException(DepartmentNotFoundException ex, WebRequest req) {
    GlobalExceptionResponse globalExceptionResponse = GlobalExceptionResponse.builder()
      .timestamp(new GregorianCalendar())
      .message(ex.getMessage())
      .details(req.getDescription(false)).build();

    return new ResponseEntity<>(globalExceptionResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DocumentTypeNotFoundException.class)
  public final ResponseEntity<Object> handleDocumentTypeNotFoundException(DocumentTypeNotFoundException ex, WebRequest req) {
    GlobalExceptionResponse globalExceptionResponse = GlobalExceptionResponse.builder()
      .timestamp(new GregorianCalendar())
      .message(ex.getMessage())
      .details(req.getDescription(false)).build();

    return new ResponseEntity<>(globalExceptionResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(CourseNotFoundException.class)
  public final ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException ex, WebRequest req) {
    GlobalExceptionResponse globalExceptionResponse = GlobalExceptionResponse.builder()
      .timestamp(new GregorianCalendar())
      .message(ex.getMessage())
      .details(req.getDescription(false)).build();

    return new ResponseEntity<>(globalExceptionResponse, HttpStatus.NOT_FOUND);
  }

}