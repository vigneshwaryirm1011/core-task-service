package com.task.core_task_service.controller;

import com.task.core_task_service.entity.Task;
import com.task.core_task_service.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskservice;


    public TaskController(TaskService taskservice) {
        this.taskservice = taskservice;
    }

    @PostMapping("/create")
    public Task create(@RequestBody Task task){
        return taskservice.createTask(task);
    }

    @GetMapping("/all")
    public List<Task> getAll(){
        return taskservice.getAll();
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskservice.getById(id);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task changes) {
        return taskservice.update(id, changes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskservice.delete(id);
    }
}
