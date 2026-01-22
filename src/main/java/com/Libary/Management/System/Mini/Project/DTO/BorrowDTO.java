package com.Libary.Management.System.Mini.Project.DTO;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowDTO{

    private Integer borrowId;
    private Integer memberId;
    private Integer bookId;
    private String memberName;
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowDTO(
            Integer borrowId,
            Integer memberId,
            Integer bookId,
            LocalDate borrowDate,
            LocalDate returnDate
    ) {
        this.borrowId = borrowId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}