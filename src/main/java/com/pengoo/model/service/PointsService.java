package com.pengoo.model.service;

import com.pengoo.model.entity.Level;
import com.pengoo.repository.PointsRepository;


public class PointsService {

    private final PointsRepository pointsRepository;
    private final LevelTracker levelTracker;
    private int totalPoints;


    public PointsService(PointsRepository pointsRepository, LevelTracker levelTracker){
        this.pointsRepository = pointsRepository;
        this.levelTracker = levelTracker;
        loadPoints();
    }

    public void loadPoints(){
       totalPoints = pointsRepository.getTotalPoints();
    }

    public void addPoints(int addedPoints){
        totalPoints += addedPoints;
        levelTracker.loadPoints(totalPoints);
        pointsRepository.savePoints(totalPoints);
    }

    public void removePoints(int addedPoints){
        totalPoints -= addedPoints;
        levelTracker.loadPoints(totalPoints);
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
