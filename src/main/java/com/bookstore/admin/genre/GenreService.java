package com.bookstore.admin.genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.admin.entity.Genre;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repo;

	public List<Genre> listAll() {
		return (List<Genre>) repo.findAll();
	}
}
