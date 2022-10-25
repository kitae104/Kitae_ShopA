package kr.inhatc.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inhatc.spring.member.dto.MemberFormDto;
import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    
    private final PasswordEncoder passwordEncoder;
        
    private final MemberService memberService;
    
    @GetMapping("/new")  
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }
    
    @PostMapping("/new")
    public String memberForm(MemberFormDto memberFormDto) {
        log.info("====================>" + memberFormDto );
        
        Member createMember = Member.createMember(memberFormDto, passwordEncoder);
        memberService.saveMember(createMember);
        
        return "redirect:/";
    }
}










