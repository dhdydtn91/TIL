package com.querydsl.study.querydslstudy.controller;

import com.querydsl.study.querydslstudy.dto.MemberSearchCondition;
import com.querydsl.study.querydslstudy.dto.MemberTeamDto;
import com.querydsl.study.querydslstudy.repository.MemberJpaRepository;
import com.querydsl.study.querydslstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;


    @GetMapping("v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition){
        return memberJpaRepository.searchByParam(condition);
    }

    @GetMapping("v2/members")
    public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition condition, Pageable pagealbe){
        return memberRepository.searchPageSimple(condition, pagealbe);
    }

    @GetMapping("v3/members")
    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition condition, Pageable pagealbe){
        return memberRepository.searchPageComplex(condition, pagealbe);
    }
}