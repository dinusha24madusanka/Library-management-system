package com.Library_Management_System.Mini_Project.Repository;

import com.Library_Management_System.Mini_Project.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
