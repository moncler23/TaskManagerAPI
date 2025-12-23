package com.example.taskmanagerapi.controller;


import com.example.taskmanagerapi.model.Task;
import com.example.taskmanagerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        return taskService.createTask(title);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public String deleteTaskByID(@PathVariable Long id) {
        return taskService.deleteByID(id);
    }





}


