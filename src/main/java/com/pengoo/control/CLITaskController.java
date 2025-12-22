package com.pengoo.control;

import com.pengoo.model.service.TaskService;
import com.pengoo.model.entity.Task;

import java.util.List;

//parse
public class CLITaskController {
    private TaskService taskService;

    public CLITaskController(){
        this.taskService = new TaskService();
    }
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    public void addTask(String title, String description, int importance){
        taskService.addTask(title, description, importance);
    }
    public void removeTask(int index){
        taskService.removeTask(index);
    }
    public void updateTask(int index){
        taskService.updateTask(index);
    }
    public void getPointsLevel(){

    }



    //helper






}
