package com.example.toby_spring.domain;

public enum Level {
    BASIC(1, "SILVER"),
    SILVER(2, "GOLD"),
    GOLD(3, "GOLD");

    private final int value;
    private final String next;

    Level(int value, String next) {
        this.value = value;
        this.next = next;
    }

    public int intValue() {
        return value;
    }

    public Level nextLevel() {
        if (this.value == values().length) {
            return valueOf(values().length);
        }
        return valueOf(this.value + 1);
    }

    public static Level valueOf(int value) {
        switch (value) {
            case 1:
                return BASIC;
            case 2:
                return SILVER;
            case 3:
                return GOLD;
            default:
                throw new AssertionError("Unknown value :" + value);
        }
    }
}
