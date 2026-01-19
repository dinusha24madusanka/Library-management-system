package com.Library_Management_System.Mini_Project.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowID;

    @ManyToOne
    @JoinColumn(name = "MemberID", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "BookID", nullable = false)
    private Book book;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    // Getters and Setters
    public Integer getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(Integer borrowID) {
        this.borrowID = borrowID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
