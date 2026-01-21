package com.Libary.Management.System.Mini.Project.Repository;

import com.Libary.Management.System.Mini.Project.Entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, Integer> {

    @Query("SELECT b FROM Borrow b WHERE b.member.memberId= :memberId")
    List<BorrowEntity> findByMemberId(@Param("memberId")Integer memberId);

    @Query("SELECT b FROM Borrow b WHERE b.book.bookId= :bookId")
    List<BorrowEntity> findByBookId(@Param("bookId")Integer bookId);

}
