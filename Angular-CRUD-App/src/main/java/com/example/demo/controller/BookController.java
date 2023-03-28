package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;

@RestController
@CrossOrigin
public class BookController 
{
	
	@Autowired
	private BookRepo repo;
	
	@PostMapping("/save")
	public String saveBookDetails(@RequestBody Book book)
	{
		System.out.println("Save API hit");
		repo.save(book);
		return "success";
	}
	
	@GetMapping("/get/{id}")
	public Book getBookById(@RequestParam int id)
	{
		Book b = repo.findById(id);
		return b;
	}

	@GetMapping("/getAll")
	public List<Book> getBookAllBook()
	{
		System.out.println("gett All API running");
		  List<Book> b = (List<Book>) repo.findAll();
		return b;
	}
	
	@PutMapping("/editDetails/{id}")
	public String editBookDetails(@PathVariable("id") int id, @RequestBody Book book)
	{
		Book b = repo.findById(id);
		
		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());
		b.setPrice(book.getPrice());
		b.setCategory(book.getCategory());
		repo.save(b);
		return "Successfully edited";
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		System.out.println("Delete API hit");
		repo.deleteById(id);
		return "Successfully deleted";
	}
}
