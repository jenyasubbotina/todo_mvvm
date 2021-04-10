package com.jenyasubbotina.todo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class AddTaskViewModel extends ViewModel {
    private final LiveData<Task> task;
    private final TasksRepository tasksRepository;

    public AddTaskViewModel(TodoDatabase database, int taskId) {
        tasksRepository = new TasksRepository(database);
        task = tasksRepository.getloadTaskById(taskId);
    }

    public LiveData<Task> getTask() {
        return task;
    }

    public void updateTask(Task task) {
        tasksRepository.updateTaskById(task);
    }
}