package com.Library_Management_System.Mini_Project.Service;

import com.Library_Management_System.Mini_Project.DTO.BorrowDTO;
import com.Library_Management_System.Mini_Project.Entity.Borrow;
import com.Library_Management_System.Mini_Project.Repository.BorrowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepo;

    public BorrowService(BorrowRepository borrowRepo) {
        this.borrowRepo = borrowRepo;
    }

    public Object returnBook(Integer borrowId, LocalDate returnDate) throws Throwable {

        Borrow borrow = borrowRepo.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        borrow.setReturnDate(returnDate);

        return borrowRepo.save(borrow);
    }

    public Borrow borrowBook(BorrowDTO dto) {
        return null;
    }
}
