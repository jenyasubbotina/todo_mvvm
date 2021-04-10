package com.jenyasubbotina.todo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.jenyasubbotina.todo.model.Task;
import com.jenyasubbotina.todo.db.TaskRepository;
import com.jenyasubbotina.todo.db.TodoDatabase;

public class AddTaskViewModel extends ViewModel {
    private final LiveData<Task> task;
    private final TaskRepository tasksRepository;

    public AddTaskViewModel(TodoDatabase database, int taskId) {
        tasksRepository = new TaskRepository(database);
        task = tasksRepository.getloadTaskById(taskId);
    }

    public LiveData<Task> getTask() {
        return task;
    }

    public void updateTask(Task task) {
        tasksRepository.updateTaskById(task);
    }
}