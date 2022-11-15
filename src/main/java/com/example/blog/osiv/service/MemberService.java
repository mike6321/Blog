package com.example.blog.osiv.service;

import com.example.blog.osiv.dto.MemberRequest;
import com.example.blog.osiv.entity.Member;
import com.example.blog.osiv.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberRequest memberRequest) {
        memberRepository.save(Member.of(memberRequest));
    }

}
