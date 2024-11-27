package us.jonathans.entity.user;

import java.util.UUID;

public class User {
    private final UUID id = UUID.randomUUID();
    private final String username;
    private final String phoneNumber;

    public User(String username, String phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
