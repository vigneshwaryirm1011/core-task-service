package com.task.core_task_service.service;

import com.task.core_task_service.entity.Task;
import com.task.core_task_service.repo.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task){
        return taskRepository.save(
                new Task(task.getTitle(), task.getDescription(), task.getStatus())
        );
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Task getById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Task not found"
                ));
    }

    @Transactional
    public Task update(Long id, Task task_change){
        Task task = getById(id);

        task.setTitle(task_change.getTitle());
        task.setDescription(task_change.getDescription());
        task.setStatus(task_change.getStatus());

        return task;
    }

    public void delete(Long id){
        Task task = getById(id);
        taskRepository.delete(task);
    }
}
