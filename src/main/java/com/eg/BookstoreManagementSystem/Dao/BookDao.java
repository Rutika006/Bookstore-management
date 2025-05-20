package com.eg.BookstoreManagementSystem.Dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eg.BookstoreManagementSystem.Dto.BookDto;
import com.eg.BookstoreManagementSystem.Repository.BookRepository;

@Repository
public class BookDao {

    @Autowired
    BookRepository repository;

    public BookDto saveBook(BookDto book) {
        repository.save(book);
        return book;
    }

    public List<BookDto> getAllBook() {
        return repository.findAll();
    }

    public BookDto getBookById(int id) {
        Optional<BookDto> opt = repository.findById(id);
        return opt.orElse(null);
    }

    public String updateBook(int id, String title, String publisher, double price, int quantity) {
        BookDto b = getBookById(id);
        if (b != null) {
            b.setAuthor(publisher);
            b.setTitle(title);
            b.setPrice(price);
            b.setQuantity(quantity);
            repository.save(b);
            return "BOOK UPDATED";
        } else {
            return "BOOK NOT FOUND";
        }
    }

    public String deleteById(int id) {
        BookDto b = getBookById(id);
        if (b != null) {
            repository.delete(b);
            return "SUCCESSFULLY DELETED";
        } else {
            return "ID NOT FOUND";
        }
    }

    public List<BookDto> getBookByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<BookDto> findBooksByPriceGreaterThan(double price) {
        return repository.findByPriceGreaterThan(price);
    }
}
