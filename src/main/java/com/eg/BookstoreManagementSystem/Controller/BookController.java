package com.eg.BookstoreManagementSystem.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eg.BookstoreManagementSystem.Dao.BookDao;
import com.eg.BookstoreManagementSystem.Dto.BookDto;

@RestController
public class BookController {

    @Autowired
    private BookDao bookdao;

    @PostMapping("/books")
    public BookDto createBook(@RequestBody BookDto bookdto) {
        return bookdao.saveBook(bookdto);
    }

    @GetMapping("/allbooks")
    public List<BookDto> getAllBooks() {
        return bookdao.getAllBook();
    }

    @GetMapping("/getbook")
    public BookDto getBookById(@RequestParam int id) {
        return bookdao.getBookById(id);
    }

    @PutMapping("/books")
    public String updateBook(@RequestParam int id, @RequestParam String title, @RequestParam String publisher, @RequestParam double price, @RequestParam int quantity) {
        return bookdao.updateBook(id, title, publisher, price, quantity);
    }

    @DeleteMapping("/books")
    public String deleteBookById(@PathVariable int id) {
        return bookdao.deleteById(id);
    }

    @GetMapping("/booktitle")
    public List<BookDto> getBooksByTitle(@RequestParam String title) {
        return bookdao.getBookByTitle(title);
    }

    @GetMapping("/bookspricegreater")
    public List<BookDto> findBooksByPriceGreaterThan(@RequestParam double price) {
        return bookdao.findBooksByPriceGreaterThan(price);
    }
}
