package com.bookstore.admin.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.admin.entity.Author;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repo;

	public List<Author> listAll() {
		return (List<Author>) repo.findAll();
	}
}
