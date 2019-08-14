package pl.sda.todo.repository;

import pl.sda.commons.repository.HibernateRepository;
import pl.sda.todo.model.Task;
import utils.HibernateUtils;

import java.time.LocalDate;
import java.util.List;

public class TaskHibernateRepository
        extends HibernateRepository<Task> implements TaskRepository {

    public TaskHibernateRepository() {
        super(Task.class);
    }

    @Override
    public List<Task> findByDates(LocalDate from, LocalDate to) {
        return HibernateUtils.getInTransaction(session ->
                session.createQuery("from Task t where" +
                        " t.date between :from and :to", Task.class)
                        .setParameter("from", from)
                        .setParameter("to", to)
                        .getResultList()
        );
    }
}
