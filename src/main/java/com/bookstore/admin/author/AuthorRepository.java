package com.bookstore.admin.author;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.admin.entity.Author;

public interface  AuthorRepository extends CrudRepository<Author, Integer>{

}
