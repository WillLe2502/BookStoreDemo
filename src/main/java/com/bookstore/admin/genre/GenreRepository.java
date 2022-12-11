package com.bookstore.admin.genre;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.admin.entity.Genre;

public interface  GenreRepository extends CrudRepository<Genre, Integer>{

}
