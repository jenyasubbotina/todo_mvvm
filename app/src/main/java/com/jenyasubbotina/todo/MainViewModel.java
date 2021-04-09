package com.jenyasubbotina.todo;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();
    private final LiveData<List<Task>> tasks;
    private final TasksRepository tasksRepository;
    public MainViewModel(Application application) {
        super(application);
        TodoDatabase database = TodoDatabase.getInstance(this.getApplication());
        tasksRepository = new TasksRepository(database);
        tasks = tasksRepository.getloadAllTasks();
    }

    public LiveData<List<Task>> getTasks() {
        return tasks;
    }

    public void deleteTask(Task taskEntry) {
        tasksRepository.deleteTasks(taskEntry);
    }
}