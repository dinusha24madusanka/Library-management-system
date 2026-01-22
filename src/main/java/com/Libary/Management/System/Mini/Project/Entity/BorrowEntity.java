package com.Libary.Management.System.Mini.Project.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Borrow")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BorrowID")
    private Integer borrowId;

    @ManyToOne
    @JoinColumn(name = "MemberID", nullable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "BookID", nullable = false)
    private BookEntity book;

    @Column(name = "BorrowDate", nullable = false)
    private LocalDate borrowDate;

    @Column(name = "ReturnDate")
    private LocalDate returnDate;
}