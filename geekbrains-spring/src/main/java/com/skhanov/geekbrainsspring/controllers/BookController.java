package com.skhanov.geekbrainsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skhanov.geekbrainsspring.data.BookRepository;
import com.skhanov.geekbrainsspring.domain.Book;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	@ModelAttribute
	public String showBookView(Model model) {
		Iterable<Book> books = bookRepository.findAll();		
		model.addAttribute("books", books);
		return "book";
	}
	
	@PostMapping
	public String addBook(Model model, @ModelAttribute("bookName") String bookName, @ModelAttribute("bookDescription") String bookDescription, @ModelAttribute("bookReleaseDate") String bookReleaseDate) {
		Book book = new Book(bookName, bookDescription);
		book.setReleaseDate(Integer.valueOf(bookReleaseDate));
		bookRepository.save(book);
		Iterable<Book> books = bookRepository.findAll();		
		model.addAttribute("books", books);
		return "book";
	}
	
}
