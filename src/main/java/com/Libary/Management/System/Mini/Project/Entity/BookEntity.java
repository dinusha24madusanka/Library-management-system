package com.Libary.Management.System.Mini.Project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Integer bookId;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "AvailableCopies", nullable = false)
    private Integer availableCopies;
}