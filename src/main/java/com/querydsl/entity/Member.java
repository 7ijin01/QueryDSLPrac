package com.querydsl.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)// n:1 LAZY는 필요할 때만 join
    private Team team;
}
