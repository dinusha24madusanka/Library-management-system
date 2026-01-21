package com.Libary.Management.System.Mini.Project.Repository;

import com.Libary.Management.System.Mini.Project.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    MemberEntity findByEmail(String email);
}