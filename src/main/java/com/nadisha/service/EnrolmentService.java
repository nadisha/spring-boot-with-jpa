package com.nadisha.service;

import java.util.List;

import com.nadisha.entity.Enrolment;

public interface EnrolmentService {
	
	public void enrolment(Long studentId, Long courseId);
	
	public List<Enrolment> getByCourseId(Long courseId);
	
	public List<Enrolment> getByStudentId(Long studentId);
}
