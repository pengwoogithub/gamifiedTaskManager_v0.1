package com.pengoo.model.entity;

public enum Level {
    NOVICE("Noob", 0),
    BEGINNER("Still a Noob",10),
    INTERMEDIATE("Slowly Improving Noob",25),
    ADVANCED("Getting Busy Noob",50),
    GOLDSTANDARD("Becoming Productive",100);


    private final String displayLevelName;
    private final int pointsReq;

    Level(String displayLevelName, int pointsReq ){
        this.displayLevelName = displayLevelName;
        this.pointsReq = pointsReq;
    }

    //getters
    public int getPointsReq(){
        return pointsReq;
    }
    public String getDisplayName(){
        return displayLevelName;
    }

}
