// BorrowService.java
package com.Libary.Management.System.Mini.Project.Service;

import com.Libary.Management.System.Mini.Project.DTO.BorrowDTO;
import com.Libary.Management.System.Mini.Project.Entity.BorrowEntity;
import com.Libary.Management.System.Mini.Project.Entity.MemberEntity;
import com.Libary.Management.System.Mini.Project.Entity.BookEntity;
import com.Libary.Management.System.Mini.Project.Repository.*;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public BorrowService(BorrowRepository borrowRepository, MemberRepository memberRepository,
                         BookRepository bookRepository) {
        this.borrowRepository = borrowRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public BorrowDTO createBorrow(BorrowDTO borrowDTO) {
        MemberEntity member = memberRepository.findById(borrowDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));
        BookEntity book = bookRepository.findById(borrowDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BorrowEntity borrow = new BorrowEntity();
        borrow.setMember(member);
        borrow.setBook(book);
        borrow.setBorrowDate(borrowDTO.getBorrowDate() != null ? borrowDTO.getBorrowDate() : LocalDate.now());
        borrow.setReturnDate(borrowDTO.getReturnDate());

        BorrowEntity savedBorrow = borrowRepository.save(borrow);
        return convertToDTO(savedBorrow);
    }

    public BorrowDTO getBorrowById(Integer id) {
        BorrowEntity borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
        return convertToDTO(borrow);
    }

    public List<BorrowDTO> getAllBorrows() {
        return borrowRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BorrowDTO updateBorrow(Integer id, BorrowDTO borrowDTO) {
        BorrowEntity borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
        borrow.setReturnDate(borrowDTO.getReturnDate());
        BorrowEntity updatedBorrow = borrowRepository.save(borrow);
        return convertToDTO(updatedBorrow);
    }

    public void deleteBorrow(Integer id) {
        borrowRepository.deleteById(id);
    }

    public List<BorrowDTO> getBorrowsByMemberId(Integer memberId) {
        return borrowRepository.findByMemberId(memberId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BorrowDTO> getBorrowsByBookId(Integer bookId) {
        return borrowRepository.findByBookId(bookId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BorrowDTO convertToDTO(BorrowEntity borrow) {
        return new BorrowDTO(borrow.getBorrowId(), borrow.getMember().getMemberId(),
                borrow.getBook().getBookId(), borrow.getBorrowDate(), borrow.getReturnDate());
    }
}