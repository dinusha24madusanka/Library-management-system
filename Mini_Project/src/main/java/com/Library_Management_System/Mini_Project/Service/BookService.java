package com.Library_Management_System.Mini_Project.Service;

import com.Library_Management_System.Mini_Project.Entity.Book;
import com.Library_Management_System.Mini_Project.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
