package com.nadisha.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadisha.dto.CourseDto;
import com.nadisha.dto.EnrolementByCourseDto;
import com.nadisha.dto.EnrolementByStudentDto;
import com.nadisha.dto.EnrolmentDto;
import com.nadisha.dto.StudentDto;
import com.nadisha.entity.Course;
import com.nadisha.entity.Enrolment;
import com.nadisha.entity.Student;
import com.nadisha.service.EnrolmentService;

@RestController
@RequestMapping("/v1/enrolments")
public class EnrolmentController {

	@Autowired
	private EnrolmentService service;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody EnrolmentDto enrolment) {
		service.enrolment(enrolment.getStudentId(), enrolment.getCourseId());
		
		return ResponseEntity.ok("Created");
	}
	
	@GetMapping("courses/{id}")
	public ResponseEntity<EnrolementByCourseDto> getByCourseId(@PathVariable(name = "id") Long courseId) {
		List<Enrolment> enrolments = service.getByCourseId(courseId);
		
		Map<Course, List<Student>> result = enrolments
				.stream()
				.collect(
						Collectors.groupingBy(
								Enrolment::getCourse, 
								Collectors.mapping(Enrolment::getStudent, Collectors.toList())
						)
				);
		
		EnrolementByCourseDto enrolmentByCourse = null;
		for(Entry<Course, List<Student>> r : result.entrySet()) {
			enrolmentByCourse = new EnrolementByCourseDto();
			
			Course course = r.getKey();
			CourseDto courseDto = new CourseDto(course.getId(), course.getName(), course.getDepartment());
			
			List<StudentDto> studentDtos = new ArrayList<>();
			for (Student s : r.getValue()) {
				studentDtos.add(new StudentDto(s.getId(), s.getFirstName(), s.getLastName(), s.getAge(), s.getEmail()));
			}
			
			enrolmentByCourse.setCourse(courseDto);
			enrolmentByCourse.setStudents(studentDtos);
			break;
		}
		
		if (enrolmentByCourse != null) {
			return ResponseEntity.ok(enrolmentByCourse);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}	
	
	@GetMapping("students/{id}")
	public ResponseEntity<EnrolementByStudentDto> getByStudentId(@PathVariable(name = "id") Long studentId) {
		List<Enrolment> enrolments = service.getByStudentId(studentId);
		
		Map<Student, List<Course>> result = enrolments
				.stream()
				.collect(
						Collectors.groupingBy(
								Enrolment::getStudent, 
								Collectors.mapping(Enrolment::getCourse, Collectors.toList())
						)
				);
		
		EnrolementByStudentDto enrolmentByStudent = null;
		for(Entry<Student, List<Course>> r : result.entrySet()) {
			enrolmentByStudent = new EnrolementByStudentDto();
			
			Student s = r.getKey();
			StudentDto studentDto = new StudentDto(s.getId(), s.getFirstName(), s.getLastName(), s.getAge(), s.getEmail());
			
			List<CourseDto> courseDtos = new ArrayList<>();
			for (Course course : r.getValue()) {
				courseDtos.add(new CourseDto(course.getId(), course.getName(), course.getDepartment()));
			}
			
			enrolmentByStudent.setStudent(studentDto);
			enrolmentByStudent.setCourses(courseDtos);
			break;
		}
		
		if (enrolmentByStudent != null) {
			return ResponseEntity.ok(enrolmentByStudent);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
