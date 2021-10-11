package com.querydsl.study.querydslstudy.dto;

import lombok.Data;

@Data
public class UserDto {

    private String name;
    private int age;

    public UserDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserDto() {
    }
}
