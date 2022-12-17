package com.bookstore.admin.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookstore.admin.entity.Publisher;

@Controller
public class PublisherController {

	@Autowired
	private PublisherService service;
	
//	@GetMapping("/publisher")
//	public String listAll(Model model) {
//		List<Publisher> listGenres = service.listAll();
//		model.addAttribute("listGenres", listGenres);
//		return "genre";
//	}
}
