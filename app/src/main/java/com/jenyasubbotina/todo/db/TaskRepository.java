package com.jenyasubbotina.todo.db;

import androidx.lifecycle.LiveData;

import com.jenyasubbotina.todo.model.Task;

import java.util.List;

public class TaskRepository  {
    private static final String LOG_TAG = TaskRepository.class
            .getSimpleName();
    private LiveData<List<Task>> tasks;
    private DaoTask taskDao;
    TodoDatabase database;
    public TaskRepository(TodoDatabase database) {
        this.database = database;
    }

    public LiveData<List<Task>> getloadAllTasks() {
        tasks = database.taskDao().loadAllTasks();
        return tasks;
    }

    public LiveData<Task> getloadTaskById(int taskId) {
        return database.taskDao().loadTaskById(taskId);
    }

    public void deleteTasks(Task taskEntry) {
        database.taskDao().deleteTask(taskEntry);
    }

    public void updateTaskById(Task task) {
        database.taskDao().updateTask(task);
    }
}
