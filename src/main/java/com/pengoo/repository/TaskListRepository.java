package com.pengoo.repository;

import com.pengoo.model.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskListRepository implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public void saveTask(Task task){
        tasks.add(task);
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }

    public Task findByIndex(int index){
        return tasks.get(index);
    }

    public ArrayList<Task> getTasks(){
        return new ArrayList<>(tasks);  //new  copy instead of exposing self
    }





    /*
    old this is bad
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

     */



}
