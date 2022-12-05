package com.bookstore.admin.book;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.admin.entity.Book;

public interface  BookRepository extends CrudRepository<Book, Integer>{

}
