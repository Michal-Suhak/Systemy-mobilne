package com.example.zad_3;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task() {
        id = UUID.randomUUID();
        date = new Date();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return this.date;
    }

    public Boolean isDone() {
        return this.done;
    }

    public void setDone(Boolean isChecked) {
        this.done = isChecked;
    }

    public String getName() {
        return this.name;
    }

    public UUID getId() {
        return this.id;
    }
}
