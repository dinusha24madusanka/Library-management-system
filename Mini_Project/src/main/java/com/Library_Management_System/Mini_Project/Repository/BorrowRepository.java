package com.Library_Management_System.Mini_Project.Repository;

import com.Library_Management_System.Mini_Project.Entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
}
