package com.api.trustacademy.exceptions;

import lombok.Builder;
import lombok.Getter;

import java.util.Calendar;

@Getter
@Builder
public class GlobalExceptionResponse {
  private Calendar timestamp;
  private String message;
  private String details;

  public GlobalExceptionResponse(Calendar timestamp, String message, String details) {
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }
}

