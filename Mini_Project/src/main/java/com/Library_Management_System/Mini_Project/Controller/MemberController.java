package com.Library_Management_System.Mini_Project.Controller;

import com.Library_Management_System.Mini_Project.Entity.Member;
import com.Library_Management_System.Mini_Project.Service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // POST → Create Member
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.save(member);
    }

    // GET → All Members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // GET → Member by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    // PUT → Update Member ✅ WORKING
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id,
            @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "Member deleted successfully";
    }
}
