package pl.sda.user.repository;

import pl.sda.commons.repository.HibernateRepository;
import pl.sda.user.model.User;
import sun.plugin2.message.Message;
import utils.HibernateUtils;

import java.security.MessageDigest;

public class UserHibernateRepository extends HibernateRepository<User>
        implements UserRepository {

    public UserHibernateRepository() {
        super(User.class);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return HibernateUtils.getInTransaction(
                session -> session
                        .createQuery("from User u where " +
                                "u.login = :login and " +
                                "u.password = :password", User.class)
                        .setParameter("login", login)
                        .setParameter("password", password)
                        .getSingleResult()
        );
    }
}
