package com.jenyasubbotina.todo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jenyasubbotina.todo.db.TaskRepository;
import com.jenyasubbotina.todo.model.Task;
import com.jenyasubbotina.todo.db.TodoDatabase;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();
    private final LiveData<List<Task>> tasks;
    private final TaskRepository tasksRepository;
    public MainViewModel(Application application) {
        super(application);
        TodoDatabase database = TodoDatabase.getInstance(this.getApplication());
        tasksRepository = new TaskRepository(database);
        tasks = tasksRepository.getloadAllTasks();
    }

    public LiveData<List<Task>> getTasks() {
        return tasks;
    }

    public void deleteTask(Task taskEntry) {
        tasksRepository.deleteTasks(taskEntry);
    }
}