package com.jenyasubbotina.todo;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DaoTask {
    @Query("SELECT * FROM task ORDER BY type")
    LiveData<List<Task>> loadAllTasks();

    @Query("SELECT * FROM task WHERE id=:id")
    LiveData<Task> loadTaskById(int id);

    @Insert
    void insertTask(Task taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(Task taskEntry);

    @Delete
    void deleteTask(Task taskEntry);
}
