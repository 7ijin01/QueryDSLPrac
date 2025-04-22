package com.querydsl.repository.custom;

import com.querydsl.dto.MemberSearchCondition;
import com.querydsl.dto.MemberTeamDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomMemberRepository
{
    List<MemberTeamDto> search(MemberSearchCondition condition);
}
