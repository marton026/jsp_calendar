package pl.sda.user.repository;

import pl.sda.user.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public enum UserHashMapRepository implements UserRepository {
    INSTANCE;

    private Map<Integer, User> data = new HashMap<>();
    private int lastId = 0;

    @Override
    public List<User> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public User findById(Integer id) {
        return data.get(id);
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++lastId);
        }
        data.put(user.getId(), user);
        return user;
    }

    @Override
    public void remove(Integer id) {
        data.remove(id);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return null;
    }
}
