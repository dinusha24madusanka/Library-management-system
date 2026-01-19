package com.Library_Management_System.Mini_Project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookID;

    private String title;
    private Integer availableCopies;

    // getters and setters
}
