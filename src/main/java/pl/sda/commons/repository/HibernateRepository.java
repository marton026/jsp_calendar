package pl.sda.commons.repository;

import utils.HibernateUtils;

import java.util.List;

public abstract class HibernateRepository<T extends DomainEntity>
        implements Repository<T>{

    private final Class<T> entityType;

    public HibernateRepository(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public List<T> findAll() {

        return HibernateUtils.getInTransaction(session -> {
            return session
                    .createQuery("from "+
                            entityType.getSimpleName(), entityType)
                    .getResultList();
        });
    }

    @Override
    public T findById(Integer id) {
        return HibernateUtils.getInTransaction( session -> {
            return session.find(entityType, id);
        });
    }

    @Override
    public T save(T entity) {
        return HibernateUtils.getInTransaction( session -> {
            if (entity.getId() == null) {
                session.persist(entity);
            }
            return (T) session.merge(entity);
        });
    }

    @Override
    public void remove(Integer id) {
        HibernateUtils.getInTransaction(session -> {
            T task = session.find(entityType, id);
            session.remove(task);
            return null;
        });
    }
}
