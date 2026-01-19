package com.Library_Management_System.Mini_Project.Controller;

import com.Library_Management_System.Mini_Project.Entity.Member;
import com.Library_Management_System.Mini_Project.Service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // ✅ MUST BE THIS
@RequestMapping("/api/members")   // ✅ MUST MATCH POSTMAN URL
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return service.save(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return service.findAll();
    }
}
