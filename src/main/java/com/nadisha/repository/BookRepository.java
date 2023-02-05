package com.nadisha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nadisha.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
