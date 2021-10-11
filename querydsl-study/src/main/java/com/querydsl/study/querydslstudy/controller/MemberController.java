package com.querydsl.study.querydslstudy.controller;

import com.querydsl.study.querydslstudy.dto.MemberSearchCondition;
import com.querydsl.study.querydslstudy.dto.MemberTeamDto;
import com.querydsl.study.querydslstudy.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;

    @GetMapping("v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition){
        return memberJpaRepository.searchByParam(condition);
    }
}
