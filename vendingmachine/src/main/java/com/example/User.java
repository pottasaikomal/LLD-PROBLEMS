package com.example;

import java.util.UUID;

public abstract class User {
    protected String userId;
    protected String name;
    // we can add email id etc..
    public User(String name) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
    }
}
