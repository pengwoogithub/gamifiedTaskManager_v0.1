package com.pengoo.repository;

import com.pengoo.config.DatabaseConnection;
import com.pengoo.model.entity.Task;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class TaskDbRepository implements TaskRepository {

    private final DatabaseConnection databaseConnection;

    public TaskDbRepository(DatabaseConnection databaseConnection){
        this.databaseConnection = databaseConnection;
    }


    @Override
    public void saveTask(Task task) {
        String sql = "INSERT INTO tasks(title, description, importance, is_done) VALUES(?,?,?,?)";

        try(Connection connection = databaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription() );
            pstmt.setInt(3, task.getImportance());
            pstmt.setBoolean(4, task.isDone());

            int affected = pstmt.executeUpdate();
            if(affected == 0){
                throw new SQLException("Creating task failed, no rows affected.");
            }
            try(ResultSet rs = pstmt.getGeneratedKeys()){
                if (rs.next()){
                    task.setId(rs.getLong(1));
                }
            }
        }catch(SQLException e){
            throw new RuntimeException("Failed to Save Task",e);
        }
    }

    @Override
    public void deleteById(long id){
        String sql = "DELETE FROM tasks WHERE id=?";

        try(Connection connection = databaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setLong(1, id);

            int affected = pstmt.executeUpdate();
            if (affected==0){
                throw new SQLException("Deletion of Task Failed, No Tasks with id = " + id);
            }

        }catch (SQLException e){
            throw new RuntimeException("Failed to Delete Task", e);
        }
    }

    @Override
    public void updateStatusDone(long id, boolean is_done) {
        String sql = "UPDATE tasks SET is_done = ? WHERE id = ?";

        try(Connection connection = databaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setBoolean(1,is_done);
            pstmt.setLong(2,id);

            int affected = pstmt.executeUpdate();
            if(affected==0){
                throw new SQLException("No Rows with id: " + id);
            }
        }catch (SQLException e){
            throw new RuntimeException("Failed to Update Task", e);
        }
    }



    @Override
    public Optional<Task> findById(long id) {
        String sql = """
                SELECT id, title, description, importance, is_done
                FROM tasks
                WHERE id = ?
                """;

        try(Connection connection = databaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setLong(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                if(!rs.next()){
                    return Optional.empty();
                }

                Task task = mapRowToTask(rs);
                return Optional.of(task);
            }


        }catch (SQLException e){
            throw new RuntimeException("No task at id = " + id, e);
        }
    }


    @Override
    public List<Task> getTasks() {

        String sql = """
                SELECT id, title, description, importance, is_done
                FROM tasks
                """;

        List<Task> tasks = new ArrayList<>();

        try(Connection connection = databaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

           ResultSet rs = pstmt.executeQuery();

           while(rs.next()){
               tasks.add(mapRowToTask(rs));
           }

           return tasks;

        } catch (SQLException e){
            throw new RuntimeException("Failed to fetch tasks", e);
        }
    }


    //mapper to wrap query result into object
    private Task mapRowToTask(ResultSet rs) throws SQLException{
        return new Task(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getInt("importance"),
            rs.getBoolean("is_done")
        );
    }



}
