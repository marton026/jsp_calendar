package pl.sda.todo.repository;

import pl.sda.todo.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository {

    List<Task> findAll();

    Task findById(Integer id);

    Task save(Task task);

    void remove(Integer id);

    List<Task> findByDates(LocalDate from, LocalDate to);
}
