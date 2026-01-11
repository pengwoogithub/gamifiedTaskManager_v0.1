package com.pengoo.repository;

import com.pengoo.model.entity.Task;
import java.util.ArrayList;

public interface TaskRepository {

    void saveTask(Task task);
    void deleteTask(Task task);
    Task findByIndex(int index);
    ArrayList<Task> getTasks();

}
