package com.pengoo.model.entity;

//need to redo action because this is fragile and prone to errors
public class Action {
    //parameters
    private final ActionType actionType;
    private final Task task;
    private int index;
    private boolean prevStatus;
    private int pointsAdded ;

    public static class Builder{
        //required
        private ActionType actionType;
        private Task task;

        //optional parameters
        private int index = 0;
        private boolean prevStatus = false;
        private int pointsAdded = 0;

        //for needed
        public Builder(ActionType actionType, Task task){
            this.actionType = actionType;
            this.task = task;
        }

        // for optional
        public Builder index(int val)
        {index = val; return this;}
        public Builder prevStatus(boolean val)
        {prevStatus = val; return this;}
        public Builder pointsAdded(int val)
        {pointsAdded = val; return this;}

        public Action build(){
            return new Action(this);
        }
    }

    //add a validity check?
    private Action(Builder builder){
        actionType = builder.actionType;
        task = builder.task;
        index = builder.index;
        prevStatus = builder.prevStatus;
        pointsAdded = builder.pointsAdded;
    }




    /*
    telescopic, very fragile
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

     */

    //getters
    public ActionType getActionType(){return actionType;}
    public int getIndex(){return index;}

}
