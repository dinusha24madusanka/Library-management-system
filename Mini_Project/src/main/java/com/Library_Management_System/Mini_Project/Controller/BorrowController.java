package com.Library_Management_System.Mini_Project.Controller;

import com.Library_Management_System.Mini_Project.DTO.BorrowDTO;
import com.Library_Management_System.Mini_Project.Entity.Borrow;
import com.Library_Management_System.Mini_Project.Service.BorrowService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/borrow")
public class BorrowController {

    private final BorrowService service;

    public BorrowController(BorrowService service) {
        this.service = service;
    }

    @PostMapping
    public Borrow borrowBook(@RequestBody BorrowDTO dto) {
        return service.borrowBook(dto);
    }
}
