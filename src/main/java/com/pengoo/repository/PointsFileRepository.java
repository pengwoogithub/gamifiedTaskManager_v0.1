package com.pengoo.repository;

import java.io.IOException;
import java.nio.file.*;

public class PointsFileRepository {

    private int totalPoints;
    private Path pointsPath = FileSystems.getDefault().getPath("data","points.txt");


    public PointsFileRepository(){

    }

    public void loadPoints(){

    }

}
