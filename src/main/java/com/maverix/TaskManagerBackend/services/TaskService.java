package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(long id);

    Task createTask(Task task);

    Task updateTask(long id, Task updatedTask);

    void deleteTask(long id);
}
