package com.nadisha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadisha.entity.Course;
import com.nadisha.repository.CourseRepository;
import com.nadisha.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository repository;
	
	@Override
	public void create(Course course) {
		repository.save(course);
	}
	
	@Override
	public List<Course> getAll() {
		return repository.findAll();
	}
	
	@Override
	public List<Course> getByName(String name) {
		return repository.findByCourseName(name);
	}
}
