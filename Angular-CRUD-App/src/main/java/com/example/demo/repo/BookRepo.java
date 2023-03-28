package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Book;


public interface BookRepo extends CrudRepository<Book, Integer> 
{
    public Book findById(int id);
}
