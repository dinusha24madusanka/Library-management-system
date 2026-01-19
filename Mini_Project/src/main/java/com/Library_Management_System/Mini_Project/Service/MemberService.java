package com.Library_Management_System.Mini_Project.Service;

import com.Library_Management_System.Mini_Project.Entity.Member;
import com.Library_Management_System.Mini_Project.Exception.ResourceNotFoundException;
import com.Library_Management_System.Mini_Project.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // CREATE
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    // READ ALL
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // READ BY ID
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    // UPDATE  ✅ FIXED
    public Member updateMember(Long id, Member updatedMember) {

        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member not found with id: " + id));

        existingMember.setName(updatedMember.getName());
        existingMember.setEmail(updatedMember.getEmail());

        return memberRepository.save(existingMember);
    }

    // DELETE
    public void deleteMember(Long id) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member not found with id: " + id));

        memberRepository.delete(member);
    }
}
