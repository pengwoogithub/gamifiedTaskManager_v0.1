package com.pengoo.model.service;

import com.pengoo.model.entity.Action;
import com.pengoo.model.entity.ActionType;
import com.pengoo.model.entity.Task;

import java.util.Optional;
import java.util.Stack;

public class ActionTracker {
    private Stack<Action> undoStack;

    public ActionTracker(){
        this.undoStack = new Stack<>();
    }

    //setters
    //maybe some validators since can add anything to anywhere
    public void actionAdd(Task task){
        Action action = new Action.Builder(ActionType.ADD,task).build();
        undoStack.push(action);
    }
    public void actionRemove(Task task, int index){
        Action action = new Action.Builder(ActionType.REMOVE, task).index(index).build();
        undoStack.push(action);
    }
    public void actionUpdate(Task task, boolean prevStatus, int pointsAdded){
        Action action = new Action.Builder(ActionType.UPDATE, task).prevStatus(prevStatus).pointsAdded(pointsAdded).build();
        undoStack.push(action);
    }

    //getter
    public Optional<Action> getLastAction(){ //check first if undostack is empty so no crash
        if(undoStack.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(undoStack.pop());
    }
}
