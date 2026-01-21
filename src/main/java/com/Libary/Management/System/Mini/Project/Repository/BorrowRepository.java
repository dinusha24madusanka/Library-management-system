package com.Libary.Management.System.Mini.Project.Repository;

import com.Libary.Management.System.Mini.Project.Entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, Integer> {
}