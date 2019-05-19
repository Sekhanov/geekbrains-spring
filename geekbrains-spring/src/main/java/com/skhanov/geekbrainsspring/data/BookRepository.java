package com.skhanov.geekbrainsspring.data;

import org.springframework.data.repository.CrudRepository;

import com.skhanov.geekbrainsspring.domain.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
}
