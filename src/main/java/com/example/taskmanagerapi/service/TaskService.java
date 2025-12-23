package com.example.taskmanagerapi.service;

import com.example.taskmanagerapi.model.Task;
import com.example.taskmanagerapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(String title){
        Task task = new Task(title);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public String deleteByID(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return "Task has been deleted";
        }
        else{
            return "No Task has been deleted";
        }
    }







}
