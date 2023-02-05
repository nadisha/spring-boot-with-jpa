package com.nadisha.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Enrolments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enrolment {
	
	@EmbeddedId
	private EnrolementId id;
	
	@ManyToOne
	@MapsId("studentId")
	@JoinColumn(
			name = "student_id",
			foreignKey = @ForeignKey(
					name = "enrolment_student_id_fk"
			)
	)
	private Student student;
	
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(
			name = "course_id",
			foreignKey = @ForeignKey(
					name = "enrolment_course_id_fk"
			)
	)	
	private Course course;
	
	@Column(
			name = "created_at",
			nullable = false,
			columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"			
	)
	private LocalDateTime createdAt;
}
