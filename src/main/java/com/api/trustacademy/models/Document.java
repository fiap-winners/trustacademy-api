package com.api.trustacademy.models;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@Entity
@Table(name = "documents")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "institute_id", nullable = false)
	private Institute institute;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	private Course course;

	@Column
	private String content;

	@CreatedDate
	private Date createdAt;

	@LastModifiedDate
	private Date modifiedAt;
}
