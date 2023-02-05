package com.nadisha.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadisha.entity.Course;
import com.nadisha.entity.EnrolementId;
import com.nadisha.entity.Enrolment;
import com.nadisha.entity.Student;
import com.nadisha.repository.EnrolmentRepository;
import com.nadisha.service.EnrolmentService;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {

	@Autowired
	private EnrolmentRepository repository;
	
	@Override
	public void enrolment(Long studentId, Long courseId) {
		EnrolementId id = new EnrolementId(studentId, courseId);
		
		Enrolment enrolment = new Enrolment(id, new Student(studentId), new Course(courseId), LocalDateTime.now());

		repository.save(enrolment);
	}

	@Override
	public List<Enrolment> getByCourseId(Long courseId) {
		List<Enrolment> enrolments = repository.findByCourseId(courseId);
		return enrolments;
	}
	
	@Override
	public List<Enrolment> getByStudentId(Long studentId) {		
		return repository.findByStudentId(studentId);
	}
}
