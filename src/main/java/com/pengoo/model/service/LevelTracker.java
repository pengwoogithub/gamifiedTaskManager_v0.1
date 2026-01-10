package com.pengoo.model.service;

import com.pengoo.model.entity.Level;

public class LevelTracker {

    private int currentXp;
    private Level currentLevel = Level.NOVICE;

    public LevelTracker(){

    }

    public void loadPoints(int addedPoints){
        this.currentXp = addedPoints;
        attributeLevel();
    }

    public void attributeLevel(){
        for (Level level: Level.values()){
            if(currentXp >= level.getPointsReq()){
                currentLevel = level;
            }
        }
    }

    public Level getCurrentLevel(){
        return currentLevel;
    }


}
