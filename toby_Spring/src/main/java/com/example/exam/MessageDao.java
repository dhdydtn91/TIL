package com.example.exam;

public class MessageDao {
    private final SimpleConnectionMaker simpleConnectionMaker;

    public MessageDao(SimpleConnectionMaker connectionMaker) {
        this.simpleConnectionMaker = connectionMaker;
    }
}
