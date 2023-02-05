package com.nadisha.service;

import java.util.List;

import com.nadisha.entity.Book;

public interface BookService {
	public void create(Book book);
	
	public void createBulk(List<Book> books);
}
