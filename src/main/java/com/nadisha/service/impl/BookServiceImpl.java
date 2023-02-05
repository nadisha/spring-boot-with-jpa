package com.nadisha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadisha.entity.Book;
import com.nadisha.repository.BookRepository;
import com.nadisha.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Override
	public void create(Book book) {
		repository.save(book);
	}
	
	@Override
	public void createBulk(List<Book> books) {
		repository.saveAll(books);
	}
}
