package com.api.trustacademy.models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

import com.api.trustacademy.serializers.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Table(name = "documents")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(using= StudentSerializer.class)
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(using= InstituteSerializer.class)
	@JoinColumn(name = "institute_id", nullable = false)
	private Institute institute;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(using= DepartmentSerializer.class)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(using= CourseSerializer.class)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(using= DocumentTypeSerializer.class)
	@JoinColumn(name = "document_type_id")
	private DocumentType type;

	@Column
	private String content;

	@CreationTimestamp
	private Calendar createdAt;

	@UpdateTimestamp
	private Calendar modifiedAt;
}