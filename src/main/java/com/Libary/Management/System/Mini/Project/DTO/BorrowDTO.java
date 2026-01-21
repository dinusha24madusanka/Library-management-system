package com.Libary.Management.System.Mini.Project.DTO;

import lombok.*;
        import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowDTO {
    private Integer borrowId;
    private Integer memberId;
    private Integer bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}