package com.pengoo.model.service;

import com.pengoo.model.entity.Task;
import com.pengoo.repository.TaskRepository;
import com.pengoo.model.service.PointsService;

import java.util.List;


// data validation, rules, storage
public class TaskService {

    private TaskRepository taskRepository;
    private ActionTracker actionTracker;
    private PointsService pointsService;

    public TaskService(){
        this.taskRepository = new TaskRepository();
        this.actionTracker = new ActionTracker();
        this.pointsService = new PointsService();
    }

    public void addTask(String title, String description, int importance){
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }

        Task task = new Task(title, description, importance);
        taskRepository.addTask(task);
        actionTracker.actionAdd(task);
    }
    public void removeTask(int index){
        index = validateAndNormalizeIndex(index);
        Task removed = taskRepository.removeTask(index);
        actionTracker.actionRemove(removed, index); //for undo stack
    }
    public void updateTask(int index){
        index = validateAndNormalizeIndex(index);
        Task task = taskRepository.getTask(index);
        boolean prevStatus = task.isDone();
        taskRepository.updateTask(index);
        int pointsAdded = task.getImportance();
        actionTracker.actionUpdate(task, prevStatus, pointsAdded); //undo stack\
        pointsService.addPoints(pointsAdded); //for points
    }

    public List<Task> getAllTasks(){
        return taskRepository.getTasks();
    }

    //helper
    private int validateAndNormalizeIndex(int index) {
        if (index <= 0 || index > taskRepository.getTasks().size()) {
            throw new IllegalArgumentException(
                    "No task at index " + index
            );
        }
        return index-1;
    }



}
