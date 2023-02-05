package com.nadisha.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nadisha.dto.BookDto;
import com.nadisha.dto.StudentDto;
import com.nadisha.dto.StudentIdCardDto;
import com.nadisha.entity.Book;
import com.nadisha.entity.Student;
import com.nadisha.entity.StudentIdCard;
import com.nadisha.service.StudentIdCardService;
import com.nadisha.service.StudentService;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentIdCardService studentIdCardService;

	/*
	 * Create a new student with books
	 */
	@PostMapping
	public ResponseEntity<String> create(@RequestBody Student student) {
		service.create(student);
		return ResponseEntity.ok("Created");
	}
	
	/*
	 * Create a new student card id for a student
	 */
	@PostMapping("{id}/student-id-card")
	public ResponseEntity<String> create(@PathVariable Long id, @RequestBody StudentIdCard idCard) {
		
		studentIdCardService.createByStudentId(idCard, id);
		
		return ResponseEntity.ok("Created");
	}
	

	/*
	 * Get all student details except books belong to each student
	 */
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAllStudents(@RequestParam(required = false) Integer age) {
		List<Student> students = new ArrayList<>();
		
		if (age == null) {
			students = service.getAll();
		} else {
			students = service.getByAge(age);
		}

		List<StudentDto> studentDtos = new ArrayList<>();
		students.forEach(s -> {
			StudentDto dto = new StudentDto(
					s.getId(), 
					s.getFirstName(), 
					s.getLastName(), 
					s.getAge(), 
					s.getEmail());
			studentDtos.add(dto);
		});

		return ResponseEntity.ok(studentDtos);
	}		

	/*
	 * Get a student detail by student id, including the books
	 */
	@GetMapping("{id}")
	public ResponseEntity<StudentDto> getStudentDetails(@PathVariable(name = "id") Long studentId) {
		Optional<Student> optionalStudent = service.getById(studentId);

		StudentDto studentDto = null;

		if (optionalStudent.isPresent()) {
			Student student = optionalStudent.get();
			List<BookDto> bookDtos = new ArrayList<>();
			for (Book b : student.getBooks()) {
				bookDtos.add(new BookDto(b.getId(), b.getBookName()));
			}
			StudentIdCard studentIdCard = student.getStudentIdCard();
			StudentIdCardDto studentIdCardDto = null;
			
			if (studentIdCard != null) {
				studentIdCardDto = new StudentIdCardDto(
						studentIdCard.getId(),
						studentIdCard.getCardNumber());
			}
			
			studentDto = new StudentDto(
					student.getId(), 
					student.getFirstName(), 
					student.getLastName(),
					student.getAge(), 
					student.getEmail(), 
					bookDtos, 
					studentIdCardDto);
		}

		if (studentDto != null) {
			return ResponseEntity.ok(studentDto);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
