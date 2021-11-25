package com.querydsl.study.querydslstudy.repository;

import com.querydsl.study.querydslstudy.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    List<Member> findByUsername(String username);
}
