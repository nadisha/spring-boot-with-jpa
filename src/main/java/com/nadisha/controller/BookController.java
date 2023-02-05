package com.nadisha.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadisha.entity.Book;
import com.nadisha.service.BookService;

@RestController
@RequestMapping("/v1/books")
public class BookController {

	@Autowired
	private BookService service;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody Book book) {
		
		// Current Date and time
		book.setCreatedAt(LocalDateTime.now());
		
		service.create(book);
		
		return ResponseEntity.ok("Created");
	}
}
