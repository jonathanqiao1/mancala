package us.jonathans.data_access.user;

import us.jonathans.entity.user.User;

import java.util.UUID;

public interface UserDataAccessInterface {
    User getUser(UUID id);

    void addUser(User user);
}
