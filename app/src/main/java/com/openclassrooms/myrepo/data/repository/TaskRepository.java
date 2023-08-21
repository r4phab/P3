package com.openclassrooms.myrepo.data.repository;

import com.openclassrooms.myrepo.data.service.TaskApi;
import com.openclassrooms.myrepo.model.Task;

import java.util.List;

public class TaskRepository {

    private final TaskApi taskApi;

    public TaskRepository() {
        taskApi = new TaskApi();
    }

    public List<Task> getTasks() {
        return taskApi.getTasks();
    }
}