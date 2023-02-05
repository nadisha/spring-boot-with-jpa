package com.nadisha.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadisha.entity.Student;
import com.nadisha.repository.StudentRepository;
import com.nadisha.service.StudentIdCardService;
import com.nadisha.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;	
	
	@Override
	public void create(Student student) {
		student.getBooks().forEach(b -> {
			if (b.getCreatedAt() == null) {
				b.setCreatedAt(LocalDateTime.now());
			}
		});		
		repository.save(student);
	}
	
	@Override
	public List<Student> getAll() {
		return repository.findAll();
	}
	
	@Override
	public Optional<Student> getById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public List<Student> getByAge(Integer age) {
		return repository.findByAgeGreaterThanEqual(age);
	}
}
