package com.bookstore.admin.genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookstore.admin.entity.Genre;

@Controller
public class GenreController {

	@Autowired
	private GenreService service;
	
	@GetMapping("/genre")
	public String listAll(Model model) {
		List<Genre> listGenres = service.listAll();
		model.addAttribute("listGenres", listGenres);
		return "genre";
	}
}
