package com.nadisha.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadisha.entity.Student;
import com.nadisha.entity.StudentIdCard;
import com.nadisha.repository.StudentIdCardRepository;
import com.nadisha.service.StudentIdCardService;
import com.nadisha.service.StudentService;

@Service
public class StudentIdCardServiceImpl implements StudentIdCardService {

	@Autowired
	private StudentIdCardRepository repository;
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public void createByStudentId(StudentIdCard idCard, Long studentId) {

		Optional<Student> optionalStudent = studentService.getById(studentId);
		
		idCard.setStudent(optionalStudent.get());
		
		repository.save(idCard);		
	}
}
