package com.Libary.Management.System.Mini.Project.Service;


import com.Libary.Management.System.Mini.Project.DTO.BookDTO;
import com.Libary.Management.System.Mini.Project.Entity.BookEntity;
import com.Libary.Management.System.Mini.Project.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO createBook(BookDTO bookDTO) {
        BookEntity book = new BookEntity();
        book.setTitle(bookDTO.getTitle());
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        BookEntity savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    public BookDTO getBookById(Integer id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return convertToDTO(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO updateBook(Integer id, BookDTO bookDTO) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDTO.getTitle());
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        BookEntity updatedBook = bookRepository.save(book);
        return convertToDTO(updatedBook);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    private BookDTO convertToDTO(BookEntity book) {
        return new BookDTO(book.getBookId(), book.getTitle(), book.getAuthor(),book.getIsbn(),book.getAvailableCopies());
    }
}