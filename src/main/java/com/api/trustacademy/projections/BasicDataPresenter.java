package com.api.trustacademy.projections;
import com.api.trustacademy.models.*;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = { Course.class, Department.class, Institute.class, Student.class, DocumentType.class })
public interface BasicDataPresenter {
  Long getId();
  String getName();
}
