package us.jonathans.data_access.user;

import us.jonathans.entity.user.User;

import java.util.HashMap;
import java.util.UUID;

public class InMemoryUserDataAccess implements UserDataAccessInterface{
    private static InMemoryUserDataAccess singletonInstance = null;

    private final HashMap<UUID, User> usersMap = new HashMap<>();

    public static InMemoryUserDataAccess getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new InMemoryUserDataAccess();
        }
        return singletonInstance;
    }

    @Override
    public User getUser(UUID id) {
        return usersMap.get(id);
    }

    @Override
    public void addUser(User user) {
        usersMap.put(user.getId(), user);
    }
}
