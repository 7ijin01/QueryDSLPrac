package com.querydsl.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberSearchCondition {
    private String username;
    private String teamName;
}