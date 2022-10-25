package kr.inhatc.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.repository.MemberRespository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{
        
    private final MemberRespository memberRespository;
    
    public Member saveMember(Member member) {
        validateDuplicate(member);
        return memberRespository.save(member);
    }

    private void validateDuplicate(Member member) {
        Member findMember = memberRespository.findByEmail(member.getEmail());
        if(findMember != null) {
            throw new IllegalStateException("이미 가입한 회원 입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Member member = memberRespository.findByEmail(email);
        
        if(member == null) {
            throw new UsernameNotFoundException("사용자가 존재하지 않습니다. " + email);
        }
             
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
















