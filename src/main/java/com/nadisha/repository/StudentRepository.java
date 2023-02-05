package com.nadisha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nadisha.entity.Student;

/*
 * Reference :- https://www.baeldung.com/spring-data-derived-queries
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByAge(Integer age);
	
	public List<Student> findByAgeGreaterThanEqual(Integer age);
}
