package com.nadisha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nadisha.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query(
			value =  "SELECT * FROM Courses WHERE LOWER(name) = ?", 
			nativeQuery = true
	)
	public List<Course> findByCourseName(String courseName);
}
