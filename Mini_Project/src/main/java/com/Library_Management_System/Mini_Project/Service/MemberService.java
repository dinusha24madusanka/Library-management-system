package com.Library_Management_System.Mini_Project.Service;

import com.Library_Management_System.Mini_Project.Entity.Member;
import com.Library_Management_System.Mini_Project.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member save(Member member) {
        return (Member) repository.save(member);
    }

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Member findById(Integer id) throws Throwable {
        return (Member) repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
