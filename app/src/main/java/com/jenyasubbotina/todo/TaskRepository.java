package com.jenyasubbotina.todo;

import androidx.lifecycle.LiveData;

import java.util.List;

class TasksRepository  {
    private static final String LOG_TAG = TasksRepository.class
            .getSimpleName();
    private LiveData<List<Task>> tasks;
    private DaoTask taskDao;
    TodoDatabase database;
    public TasksRepository(TodoDatabase database) {
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
