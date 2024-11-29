package us.jonathans.entity.user;

import java.util.UUID;

public class User {
    private final UUID id = UUID.randomUUID();
    private final String username;
    private final String phoneNumber;
    private final boolean usePhoneNumber;

    public User(String username, String phoneNumber, boolean usePhoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.usePhoneNumber = usePhoneNumber;
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

    public boolean isUsePhoneNumber() {
        return usePhoneNumber;
    }
}
