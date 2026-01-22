package com.Libary.Management.System.Mini.Project.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Integer bookId;
    private String title;
    private String author;
    private String isbn;
    private Integer availableCopies;
}