package com.pengoo.repository;

import java.io.IOException;
import java.nio.file.*;

public class PointsFileRepository implements PointsRepository{


    private int totalPoints;
    private Path pointsPath = FileSystems.getDefault().getPath("data","points.txt");


    public PointsFileRepository(){
        loadPointsFile();
    }

    public void loadPointsFile(){
        try{
            if(Files.exists(pointsPath)){
                totalPoints = Integer.parseInt(Files.readString(pointsPath));
            }
            else{
                totalPoints = 0;
                Files.createDirectories(pointsPath.getParent());
                Files.writeString(pointsPath,"0");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public int getTotalPoints(){return totalPoints;}

    @Override
    //file save
    public void savePoints(int totalPoints){
        try{
            Files.writeString(pointsPath, String.valueOf(totalPoints));
        }
        catch (IOException e){
            System.out.println("Error reading file.");
        }
    }



}
