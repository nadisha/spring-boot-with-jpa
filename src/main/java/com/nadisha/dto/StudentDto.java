package com.nadisha.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class StudentDto {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private String email;
		
	private List<BookDto> books;
	
	private StudentIdCardDto studentIdCard;

	public StudentDto(Long id, String firstName, String lastName, Integer age, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
	}

	public StudentDto(Long id, String firstName, String lastName, Integer age, String email, List<BookDto> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.books = books;
	}

	public StudentDto(Long id, String firstName, String lastName, Integer age, String email, List<BookDto> books,
			StudentIdCardDto studentIdCard) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.books = books;
		this.studentIdCard = studentIdCard;
	}
}	
