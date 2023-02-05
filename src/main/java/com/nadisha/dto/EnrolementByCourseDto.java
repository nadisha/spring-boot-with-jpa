package com.nadisha.dto;

import java.util.List;

import lombok.Data;

@Data
public class EnrolementByCourseDto {
	
	private CourseDto course;
	
	private List<StudentDto> students;
}
