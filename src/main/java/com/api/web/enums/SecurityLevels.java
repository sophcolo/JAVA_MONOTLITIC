package com.api.web.enums;

public enum SecurityLevels {
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private final int value;

    SecurityLevels(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
