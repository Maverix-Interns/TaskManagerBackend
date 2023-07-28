package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.Task;
import com.maverix.TaskManagerBackend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(long id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setT_name(updatedTask.getT_name());
            task.setT_desc(updatedTask.getT_desc());
            task.setT_deadline(updatedTask.getT_deadline());
            task.setUser(updatedTask.getUser());
            task.setTask_assigned(updatedTask.getTask_assigned());
            task.setTask_completed(updatedTask.getTask_completed());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        }
        return null;
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
