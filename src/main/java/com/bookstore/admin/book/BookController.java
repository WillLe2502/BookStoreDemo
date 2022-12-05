package com.bookstore.admin.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookstore.admin.entity.Book;

@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/bookList")
	public String listAll(Model model) {
		List<Book> listBooks = service.listAll();
		model.addAttribute("listBooks", listBooks);
		return "bookList";
	}
}
