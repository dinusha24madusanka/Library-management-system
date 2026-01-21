package com.Libary.Management.System.Mini.Project.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer bookId;
    private String title;
    private Integer availableCopies;
}