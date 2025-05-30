package com.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

public class MemberTeamDto {
    private Long memberId;
    private String username;
    private int age;
    private String teamName;
    @QueryProjection
    public MemberTeamDto(Long memberId, String username, int age, String teamName) {
        this.memberId = memberId;
        this.username = username;
        this.age = age;
        this.teamName = teamName;
    }
}
