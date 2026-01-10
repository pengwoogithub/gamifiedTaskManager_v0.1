package com.pengoo.model.service;

import com.pengoo.model.entity.Level;
import com.pengoo.repository.PointsFileRepository;
import com.pengoo.repository.PointsRepository;


public class PointsService {

    private PointsRepository pointsRepository;
    private LevelTracker levelTracker;
    private int totalPoints;


    public PointsService(PointsRepository pointsRepository, LevelTracker levelTracker){
        this.pointsRepository = pointsRepository;
        this.levelTracker = levelTracker;
    }

    public void loadPoints(){
        this.totalPoints = pointsRepository.getTotalPoints();
    }

    public void addPoints(int addedPoints){
        totalPoints += addedPoints;


        levelTracker.loadPoints(addedPoints);
    }

    public void removePoints(int addedPoints){


        levelTracker.loadPoints(addedPoints);
    }

    public Level getCurrentLevel(){
        return levelTracker.getCurrentLevel();
    }

    /*
     public void addPointsFile(int addedPoints){
        totalPoints += addedPoints;
        writePointsToFile(totalPoints);
    }

    public void minusPointsFile(int addedPoints){
        totalPoints -= addedPoints;
        writePointsToFile(totalPoints);
    }

    */


}
