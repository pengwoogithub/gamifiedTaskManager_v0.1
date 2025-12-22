package com.pengoo.model.entity;


public class Action {
    public enum ActionType{ADD,REMOVE,UPDATE}

    private ActionType actionType;
    private Task task;
    private int index;
    private boolean prevStatus;
    private int pointsAdded;

    //constructor per action type
    //Add
    public Action(ActionType actionType, Task task){
        this.actionType = actionType;
        this.task = task;
    }
    //Remove
    public Action(ActionType actionType, Task task, int index){
        this.actionType = actionType;
        this.task = task;
        this.index = index;
    }
    //Update
    public Action(ActionType actionType, Task task, boolean prevStatus, int pointsAdded){
        this.actionType = actionType;
        this.task = task;
        this.prevStatus = prevStatus;
        this.pointsAdded = pointsAdded;
    }

    //getters
    public ActionType getActionType(){return actionType;}
    public int getIndex(){return index;}






}
