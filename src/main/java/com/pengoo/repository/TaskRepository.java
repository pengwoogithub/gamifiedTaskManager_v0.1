package com.pengoo.repository;

import com.pengoo.model.entity.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    void saveTask(Task task);
    void deleteById(long id);
    void updateStatusDone(long id, boolean is_Done);

    Optional<Task> findById(long id);

    List<Task> getTasks();

}
