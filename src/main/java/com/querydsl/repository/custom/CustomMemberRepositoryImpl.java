package com.querydsl.repository.custom;

import com.querydsl.dto.MemberSearchCondition;
import com.querydsl.dto.MemberTeamDto;
import com.querydsl.dto.QMemberTeamDto;
import com.querydsl.entity.QMember;
import com.querydsl.entity.QTeam;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class CustomMemberRepositoryImpl implements CustomMemberRepository
{
    private final JPAQueryFactory queryFactory;
    @Override
    public List<MemberTeamDto> search(MemberSearchCondition condition) {
        QMember member = QMember.member;
        QTeam team = QTeam.team;
        return queryFactory
                .select(new QMemberTeamDto(
                        member.id,
                        member.username,
                        member.age,
                        team.name
                ))
                .from(member)
                .leftJoin(member.team, team)
                .where(
                        StringUtils.hasText(condition.getUsername()) ? member.username.eq(condition.getUsername()) : null,
                        StringUtils.hasText(condition.getTeamName()) ? team.name.eq(condition.getTeamName()) : null
                )
                .fetch();

    }
}
