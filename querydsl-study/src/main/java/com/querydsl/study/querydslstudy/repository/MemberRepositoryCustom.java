package com.querydsl.study.querydslstudy.repository;

import com.querydsl.study.querydslstudy.dto.MemberSearchCondition;
import com.querydsl.study.querydslstudy.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom{
    List<MemberTeamDto> search(MemberSearchCondition condition);

}
