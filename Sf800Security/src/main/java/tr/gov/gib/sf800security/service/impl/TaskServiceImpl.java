package tr.gov.gib.sf800security.service.impl;

import org.springframework.stereotype.Service;
import tr.gov.gib.sf800security.dao.model.Task;
import tr.gov.gib.sf800security.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import  tr.gov.gib.sf800security.dao.impl.TaskRepositoryImpl;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepositoryImpl taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id);
    }
    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void update(Task task) {
        Task existingTask = taskRepository.findById(task.getId());
        if (existingTask != null) {
            taskRepository.update(task);
        } else {
            // Handle the case where the task doesn't exist
        }
    }

    @Override
    public void delete(Long id) {
        taskRepository.delete(id);
    }
}