package com.querydsl.service;


import com.querydsl.dto.MemberSearchCondition;
import com.querydsl.dto.MemberTeamDto;
import com.querydsl.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberTeamDto> search(MemberSearchCondition condition) {
        return memberRepository.search(condition);
    }
    public List<MemberTeamDto> searchOld(MemberSearchCondition condition) {
        return memberRepository.search(condition);
    }
}

