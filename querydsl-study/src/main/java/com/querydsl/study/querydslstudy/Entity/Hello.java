package com.querydsl.study.querydslstudy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Hello {

    @Id
    @GeneratedValue
    private Long id;
}
