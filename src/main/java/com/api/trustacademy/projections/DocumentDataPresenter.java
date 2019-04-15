package com.api.trustacademy.projections;
import java.util.Date;

import com.api.trustacademy.models.*;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = { Document.class })
public interface DocumentDataPresenter {

	Long getId();
	String getContent();
	Date getCreatedAt();
	Date getModifiedAt();

	DocumentType getType();
	Student getStudent();
	Institute getInstitute();
	Department getDepartment();
	Course getCourse();
}
