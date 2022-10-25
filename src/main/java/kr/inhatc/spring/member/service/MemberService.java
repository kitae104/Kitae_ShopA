package kr.inhatc.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.repository.MemberRespository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
        
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
}
