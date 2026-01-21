package com.Libary.Management.System.Mini.Project.Repository;

import com.Libary.Management.System.Mini.Project.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findByTitle(String title);
}