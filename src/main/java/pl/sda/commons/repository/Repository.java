package pl.sda.commons.repository;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();

    T findById(Integer id);

    T save(T entity);

    void remove(Integer id);

}
