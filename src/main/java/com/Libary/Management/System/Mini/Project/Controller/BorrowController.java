package com.Libary.Management.System.Mini.Project.Controller;

import com.Libary.Management.System.Mini.Project.DTO.BorrowDTO;
import com.Libary.Management.System.Mini.Project.Service.BorrowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public ResponseEntity<BorrowDTO> createBorrow(@RequestBody BorrowDTO borrowDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(borrowService.createBorrow(borrowDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowDTO> getBorrow(@PathVariable Integer id) {
        return ResponseEntity.ok(borrowService.getBorrowById(id));
    }

    @GetMapping
    public ResponseEntity<List<BorrowDTO>> getAllBorrows() {
        return ResponseEntity.ok(borrowService.getAllBorrows());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowDTO> updateBorrow(@PathVariable Integer id, @RequestBody BorrowDTO borrowDTO) {
        return ResponseEntity.ok(borrowService.updateBorrow(id, borrowDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable Integer id) {
        borrowService.deleteBorrow(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<BorrowDTO>> getBorrowsByMember(@PathVariable Integer memberId) {
        return ResponseEntity.ok(borrowService.getBorrowsByMemberId(memberId));
    }
}