package com.nadisha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nadisha.entity.EnrolementId;
import com.nadisha.entity.Enrolment;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, EnrolementId> {

	public List<Enrolment> findByCourseId(Long courseid);
	
	public List<Enrolment> findByStudentId(Long studentId);
}
