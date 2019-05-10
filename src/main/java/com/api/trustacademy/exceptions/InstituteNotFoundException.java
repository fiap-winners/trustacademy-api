package com.api.trustacademy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InstituteNotFoundException extends RuntimeException {
  public InstituteNotFoundException(String message) {
    super(message);
  }
}
