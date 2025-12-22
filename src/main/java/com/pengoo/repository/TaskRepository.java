package com.pengoo.repository;

import com.pengoo.model.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private List<Task> tasks;

    public TaskRepository(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public Task removeTask(int index){
        return tasks.remove(index);
    }
    public Task updateTask(int index){
        tasks.get(index).setDone();
        return tasks.get(index);
    }

    //getters
    public List<Task> getTasks(){
        return tasks;
    }
    public Task getTask(int index){
        return tasks.get(index);
    }



}
