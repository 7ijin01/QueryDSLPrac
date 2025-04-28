package com.querydsl.repository.custom;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.dto.MemberSearchCondition;
import com.querydsl.dto.MemberTeamDto;
import com.querydsl.dto.QMemberTeamDto;
import com.querydsl.entity.Member;
import com.querydsl.entity.QMember;
import com.querydsl.entity.QTeam;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class CustomMemberRepositoryImpl implements CustomMemberRepository
{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberTeamDto> searchOld(MemberSearchCondition condition) {
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
                        usernameEq(condition.getUsername()),
                        teamNameEq(condition.getTeamName()),
                        ageGoe1()
                )
                .fetch();
    }
    private BooleanExpression usernameEq(String username) {
        return StringUtils.hasText(username) ? QMember.member.username.eq(username) : null;
    }

    private BooleanExpression teamNameEq(String teamName) {
        return StringUtils.hasText(teamName) ? QTeam.team.name.eq(teamName) : null;
    }

    private BooleanExpression ageGoe1() {
        return QMember.member.age.goe(1);
    }

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
