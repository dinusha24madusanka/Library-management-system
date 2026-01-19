package com.Library_Management_System.Mini_Project.Controller;

import com.Library_Management_System.Mini_Project.Entity.Book;
import com.Library_Management_System.Mini_Project.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return service.findAll();
    }
}
