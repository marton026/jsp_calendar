package pl.sda.todo.repository;

import pl.sda.todo.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TaskHashMapRepository implements TaskRepository {
    INSTANCE;

    private Map<Integer, Task> data = new HashMap<>();
    private Integer lastId = 0;

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Task findById(Integer id) {
        return data.get(id);
    }

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(++lastId);
        }
        data.put(task.getId(), task);
        return task;
    }

    @Override
    public void remove(Integer id) {
        data.remove(id);
    }

    @Override
    public List<Task> findByDates(LocalDate from, LocalDate to) {
        return null;
    }
}
