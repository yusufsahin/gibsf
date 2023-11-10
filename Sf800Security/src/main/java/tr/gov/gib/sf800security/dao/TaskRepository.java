package tr.gov.gib.sf800security.dao;

import tr.gov.gib.sf800security.dao.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    void save(Task task);
    void update(Task task);
    void delete(Long id);
}
