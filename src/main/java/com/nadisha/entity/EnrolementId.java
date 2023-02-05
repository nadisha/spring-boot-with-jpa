package com.nadisha.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class EnrolementId implements Serializable{
	
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "course_id")
	private Long courseId;	
}
