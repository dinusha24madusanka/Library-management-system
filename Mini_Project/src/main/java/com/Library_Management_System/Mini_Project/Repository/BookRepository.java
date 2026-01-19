package com.Library_Management_System.Mini_Project.Repository;

import com.Library_Management_System.Mini_Project.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
