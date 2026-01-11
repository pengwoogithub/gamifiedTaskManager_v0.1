package com.pengoo.model.service;

import com.pengoo.model.entity.Task;
import com.pengoo.repository.TaskListRepository;

import java.util.List;


// data validation, rules, storage
public class TaskService {

    private final TaskListRepository taskListRepository;
    private final ActionTracker actionTracker;
    private final PointsService pointsService;

    public TaskService(TaskListRepository taskListRepository, ActionTracker actionTracker, PointsService pointsService){
        this.taskListRepository = taskListRepository;
        this.actionTracker = actionTracker;
        this.pointsService = pointsService;
    }

    public void addTask(String title, String description, int importance){
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }

        Task task = new Task(title, description, importance);
        taskListRepository.saveTask(task);
        actionTracker.actionAdd(task);
    }
    public void removeTask(int index){
        index = validateAndNormalizeIndex(index);

        Task removed = taskListRepository.findByIndex(index);
        taskListRepository.deleteTask(removed);
        actionTracker.actionRemove(removed, index); //for undo stack
    }
    public void updateTask(int index){
        index = validateAndNormalizeIndex(index);
        Task task = taskListRepository.findByIndex(index);
        boolean prevStatus = task.isDone();
        taskListRepository.findByIndex(index).setDone();
        int pointsAdded = task.getImportance();
        actionTracker.actionUpdate(task, prevStatus, pointsAdded); //undo stack\
        pointsService.addPoints(pointsAdded); //for points
    }

    public List<Task> getAllTasks(){
        return taskListRepository.getTasks();
    }

    //helper
    private int validateAndNormalizeIndex(int index) {
        if (index <= 0 || index > taskListRepository.getTasks().size()) {
            throw new IllegalArgumentException(
                    "No task at index " + index
            );
        }
        return index-1;
    }



}
