package com.jenyasubbotina.todo.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity (tableName = "tasks")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private long id = 0;
    private String description;
    private String type;
    @ColumnInfo(name = "updatet_at")
    private Date done;

    @Ignore
    public Task(String description, String type, Date done) {
        this.description = description;
        this.type = type;
        this.done = done;
    }

    public Task(long id, String description, String type, Date done) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Date getDone() {
        return done;
    }

    public void setDone(Date done) {
        this.done = done;
    }
}
