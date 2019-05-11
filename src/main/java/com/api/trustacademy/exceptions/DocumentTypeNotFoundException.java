package com.api.trustacademy.exceptions;

public class DocumentTypeNotFoundException extends RuntimeException {
  public DocumentTypeNotFoundException(String message) {
    super(message);
  }
}
