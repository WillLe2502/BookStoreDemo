package com.bookstore.admin.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookstore.admin.entity.Author;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService service;
	
	@GetMapping("/authorList")
	public String listAll(Model model) {
		List<Author> listAuthors = service.listAll();
		model.addAttribute("listAuthors", listAuthors);
		return "authorList";
	}
}
