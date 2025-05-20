package com.eg.BookstoreManagementSystem.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eg.BookstoreManagementSystem.Dto.BookDto;

public interface BookRepository extends JpaRepository<BookDto,Integer>{
//creating our own query
	
	List<BookDto>findByTitle(String title);
	List<BookDto>findByPriceGreaterThan(Double price);

}
