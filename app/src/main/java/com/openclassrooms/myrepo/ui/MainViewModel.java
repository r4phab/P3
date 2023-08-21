package com.openclassrooms.myrepo.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.myrepo.data.repository.TaskRepository;
import com.openclassrooms.myrepo.model.Task;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final TaskRepository taskRepository;
    private final MutableLiveData<List<Task>> tasksLiveData;

    public MainViewModel() {
        taskRepository = new TaskRepository();
        tasksLiveData = new MutableLiveData<>();
        loadTasks();
    }

    public LiveData<List<Task>> getTasks() {
        return tasksLiveData;
    }

    private void loadTasks() {
        List<Task> tasks = taskRepository.getTasks();
        tasksLiveData.postValue(tasks);
    }
}
