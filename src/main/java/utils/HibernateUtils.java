package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Environment;
import pl.sda.todo.model.Task;
import pl.sda.user.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static <T> T getInTransaction(Function<Session, T> action) {
        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        Transaction transaction = currentSession.beginTransaction();

        T result = null;
        try {
            result = action.apply(currentSession);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            currentSession.close();
        }
        return result;
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            Map<String, String> properties = new HashMap<>();
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/task_base?allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=CET&useSSL=false&characterEncoding=UTF-8");
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "Nicram00");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            registryBuilder.applySettings(properties);

            registryBuilder.addService(ClassLoaderService.class, new ClassLoaderServiceImpl(HibernateUtils.class.getClassLoader()));

            StandardServiceRegistry serviceRegistry = registryBuilder.build();
            Metadata metadata = new MetadataSources(serviceRegistry)
                    .addAnnotatedClass(Task.class)
                    .addAnnotatedClass(User.class)
                    .getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;

    }

}