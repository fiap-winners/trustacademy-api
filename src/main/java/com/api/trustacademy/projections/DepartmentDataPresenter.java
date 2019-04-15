package com.api.trustacademy.projections;
import com.api.trustacademy.models.Course;
import com.api.trustacademy.models.Department;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types = { Department.class })
public interface DepartmentDataPresenter {
  Long getId();
  String getName();
  Set<Course> getCourses();
}
