package com.api.trustacademy.projections;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.api.trustacademy.models.Course;
import com.api.trustacademy.models.Department;
import com.api.trustacademy.models.Document;
import com.api.trustacademy.models.Institute;
import com.api.trustacademy.models.Student;

@Projection(types = { Document.class })
public interface DocumentDataPresenter {

	Long getId();
	String getContent();
	Date getCreatedAt();
	Date getModifiedAt();
	
	Student getStudent();
	Institute getInstitute();
	Department getDepartment();
	Course getCourse();
}
