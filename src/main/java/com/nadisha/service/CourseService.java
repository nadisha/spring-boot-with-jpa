package com.nadisha.service;

import java.util.List;

import com.nadisha.entity.Course;

public interface CourseService {

	public void create(Course course);
	
	public List<Course> getAll();
	
	public List<Course> getByName(String name);
}
