package com.example.zad_3;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    private final List<Task> tasks;

    public static TaskStorage getInstance() {
        return taskStorage;
    }

    private TaskStorage() {
        tasks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Task task = new Task();
            task.setName("Pilne zadanie numer " + i);
            if ( i%3 == 0 ){
                task.setCategory(Category.STUDIES);
            }
            else{
                task.setCategory(Category.HOME);
            }
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public List<Task> getTaskList() {
        return tasks;
    }

    public Task getTask(UUID taskId) {
        for(Task task:tasks){
            if(task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }
}
