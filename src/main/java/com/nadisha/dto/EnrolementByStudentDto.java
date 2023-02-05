package com.nadisha.dto;

import java.util.List;

import lombok.Data;

@Data
public class EnrolementByStudentDto {
	
	private StudentDto student;
	
	private List<CourseDto> courses;
}
