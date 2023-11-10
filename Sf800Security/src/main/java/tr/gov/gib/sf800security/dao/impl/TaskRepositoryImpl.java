package tr.gov.gib.sf800security.dao.impl;

import org.springframework.stereotype.Repository;
import tr.gov.gib.sf800security.dao.TaskRepository;
import tr.gov.gib.sf800security.dao.model.Task;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Task findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Task task) {
        task.setId(idCounter.incrementAndGet());
        tasks.add(task);
    }
    @Override
    public void update(Task task) {
        Task existingTask = findById(task.getId());
        if (existingTask != null) {
            existingTask.setName(task.getName());
            existingTask.setDescription(task.getDescription());
            existingTask.setHour(task.getHour());
            existingTask.setCompleted(task.isCompleted());
        }
    }

    @Override
    public void delete(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}