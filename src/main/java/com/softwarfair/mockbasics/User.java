package com.softwarfair.mockbasics;

public class User {
    private final boolean active;

    public User(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
