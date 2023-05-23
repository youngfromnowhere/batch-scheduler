package com.cmjc.batchscheduler.batch.entity;

public enum RepeatMode {

    DAILY("DAILY"),
    WEEKLY("WEEKLY"),
    MONTHLY("MONTHLY"),
    YEARLY("YEARLY");

    private final String mode;
    RepeatMode(String mode) {
        this.mode = mode;
    }
}
