package com.querydsl.repository;

import com.querydsl.entity.Member;
import com.querydsl.repository.custom.CustomMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {
}
