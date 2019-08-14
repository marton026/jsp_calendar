package pl.sda.user.repository;

import pl.sda.user.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findById(Integer id);

    User save(User save);

    void remove(Integer id);

    User findByLoginAndPassword(String login, String password);

}
