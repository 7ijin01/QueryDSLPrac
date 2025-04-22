package com.querydsl.controller;


import com.querydsl.dto.MemberSearchCondition;
import com.querydsl.dto.MemberTeamDto;
import com.querydsl.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController
{
    private final MemberService memberService;

    @GetMapping
    public List<MemberTeamDto> search(@RequestBody MemberSearchCondition condition) {
        return memberService.search(condition);
    }
}
