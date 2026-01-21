package com.Libary.Management.System.Mini.Project.Service;

import com.Libary.Management.System.Mini.Project.DTO.MemberDTO;
import com.Libary.Management.System.Mini.Project.Entity.MemberEntity;
import com.Libary.Management.System.Mini.Project.Repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberDTO createMember(MemberDTO memberDTO) {
        MemberEntity member = new MemberEntity();
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        MemberEntity savedMember = memberRepository.save(member);
        return convertToDTO(savedMember);
    }

    public MemberDTO getMemberById(Integer id) {
        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return convertToDTO(member);
    }

    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MemberDTO updateMember(Integer id, MemberDTO memberDTO) {
        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        MemberEntity updatedMember = memberRepository.save(member);
        return convertToDTO(updatedMember);
    }

    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

    private MemberDTO convertToDTO(MemberEntity member) {
        return new MemberDTO(member.getMemberId(), member.getName(), member.getEmail());
    }
}