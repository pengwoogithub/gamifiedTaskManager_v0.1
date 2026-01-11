package com.pengoo.control;

import com.pengoo.model.entity.Level;
import com.pengoo.model.service.TaskService;
import com.pengoo.model.service.PointsService;
import com.pengoo.model.entity.Task;

import java.util.List;


//parseaea
public class CLITaskController {
    private final TaskService taskService;
    private final PointsService pointsService;

    public CLITaskController(TaskService taskService, PointsService pointsService){
       this.taskService = taskService;
       this.pointsService = pointsService;
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
    //return the current Level and points/xp since xp=points
    public Level getPointsLevel(){
        return pointsService.getCurrentLevel();
    }


    //helper






}
