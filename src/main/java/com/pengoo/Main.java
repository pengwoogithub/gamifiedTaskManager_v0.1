package com.pengoo;

import com.pengoo.boundary.TaskMenu;
import com.pengoo.control.CLITaskController;
import com.pengoo.model.service.ActionTracker;
import com.pengoo.model.service.LevelTracker;
import com.pengoo.model.service.PointsService;
import com.pengoo.model.service.TaskService;
import com.pengoo.repository.PointsFileRepository;
import com.pengoo.repository.PointsRepository;
import com.pengoo.repository.TaskRepository;
import com.pengoo.view.DisplayText;


public class Main {
    public static void main(String[] args) {
        PointsRepository pointsRepository = new PointsFileRepository();
        LevelTracker levelTracker = new LevelTracker();

        TaskRepository taskRepository = new TaskRepository();
        ActionTracker actionTracker = new ActionTracker();


        PointsService pointsService = new PointsService(pointsRepository, levelTracker);

        TaskService taskService = new TaskService(taskRepository, actionTracker, pointsService);
        CLITaskController controller = new CLITaskController(taskService, pointsService);
        DisplayText displayText = new DisplayText();
        TaskMenu taskMenu = new TaskMenu(controller, displayText);


        taskMenu.run();

    }

}