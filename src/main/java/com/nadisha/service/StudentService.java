package com.nadisha.service;

import java.util.List;
import java.util.Optional;

import com.nadisha.entity.Student;

public interface StudentService {

	public void create(Student student);
	
	public List<Student> getAll();
	
	public Optional<Student> getById(Long id);
	
	public List<Student> getByAge(Integer age);
}
