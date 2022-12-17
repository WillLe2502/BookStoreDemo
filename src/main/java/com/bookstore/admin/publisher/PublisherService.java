package com.bookstore.admin.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.admin.entity.Publisher;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository repo;
	
	public List<Publisher> listAll() {
		return (List<Publisher>)repo.findAll();
	}
}
