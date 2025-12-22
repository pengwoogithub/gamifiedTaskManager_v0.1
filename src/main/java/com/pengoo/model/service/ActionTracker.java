package com.pengoo.model.service;

import com.pengoo.model.entity.Action;
import com.pengoo.model.entity.Task;

import java.util.Optional;
import java.util.Stack;

public class ActionTracker {
    private Stack<Action> undoStack;

    public ActionTracker(){
        this.undoStack = new Stack<>();
    }

    //setters
    public void actionAdd(Task task){
        undoStack.push(new Action(Action.ActionType.ADD, task));
    }
    public void actionRemove(Task task, int index){
        undoStack.push(new Action(Action.ActionType.REMOVE, task, index));
    }
    public void actionUpdate(Task task, boolean prevStatus, int pointsAdded){
        undoStack.push(new Action(Action.ActionType.UPDATE, task, prevStatus, pointsAdded));
    }

    //getter
    public Optional<Action> getLastAction(){ //check first if undostack is empty so no crash
        if(undoStack.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(undoStack.pop());
    }
}
