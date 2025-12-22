package com.pengoo.model.entity;

public class Task {
    private String title;
    private String description;
    private int importance;
    private boolean done;


    public Task(String title, String description, int importance){
        this.title = title;
        this.description = description;
        this.importance = importance;
    }

    //setters
    public void setTitle(){}
    public void setDescription(){};
    public void setImportance(){};
    public void setDone(){done = true;};


    //getters
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public int getImportance(){return importance;}
    public boolean isDone(){return done;}
}
