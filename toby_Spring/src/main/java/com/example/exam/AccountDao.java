package com.example.exam;

public class AccountDao {
    private final SimpleConnectionMaker simpleConnectionMaker;

    public AccountDao(SimpleConnectionMaker connectionMaker) {
        this.simpleConnectionMaker = connectionMaker;
    }
}
