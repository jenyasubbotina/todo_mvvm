package com.jenyasubbotina.todo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity (tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private final long id;
    private final String description;
    private final int type;
    @ColumnInfo(name = "done")
    private final boolean done;

    public Task(int id, String description, int priority, boolean done) {
        this.id = id;
        this.description = description;
        this.type = priority;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }

    public boolean getIfDone() {
        return done;
    }
}
