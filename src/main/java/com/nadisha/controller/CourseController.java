package com.nadisha.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nadisha.dto.CourseDto;
import com.nadisha.entity.Course;
import com.nadisha.service.CourseService;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody Course course){
		service.create(course);
		return ResponseEntity.ok("Created");
	}
	
	@GetMapping
	public ResponseEntity<List<CourseDto>> getAll(@RequestParam(name = "name", required = false) String courseName) {
		List<Course> courses = new ArrayList<>();
		
		if (courseName == null) {
			courses = service.getAll();
		} else {
			courses = service.getByName(courseName);
		}
		
		List<CourseDto> courseDtos = new ArrayList<>();
		courses.forEach(c -> {
			courseDtos.add(new CourseDto(c.getId(), c.getName(), c.getDepartment()));
		});
		
		return ResponseEntity.ok(courseDtos);
	}	
}
