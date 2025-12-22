package com.pengoo.view;

import com.pengoo.model.entity.Task;
import java.util.List;

public class DisplayText {

    //Menu
    public void displayMenu(){
        System.out.println("Menu\n1.Show Tasks\n2.Add Task\n3.Remove Task\n4.Update Task\n5.Shows Points and Level\n6.Undo Last Action\n7.Exit");
    }

    public void displayAllTasks(List<Task> tasks){
        System.out.println("--Displaying All Tasks--");
        //check if empty first

        System.out.printf("%-3s %-20s %-30s %-10s %-12s\n",
                "No.", "Title", "Description", "Importance", "Completed");
        int idx = 1;
        for (Task task : tasks) {
            String title = task.getTitle().length() > 20 ? task.getTitle().substring(0,17) + "..." : task.getTitle();
            String desc = task.getDescription().length() > 30 ? task.getDescription().substring(0,27) + "..." : task.getDescription();
            String completed = task.isDone() ? "✔" : "✘";

            System.out.printf("%-3d %-20s %-30s %-10d %-12s\n", idx++, title, desc, task.getImportance(), completed);
        }
    }

    //Add Task
    public void displayTitlePrompt(){
        System.out.println("--Task Add--");
        System.out.println("Title of Task to be added: ");
    }
    public void displayDescriptionPrompt(){
        System.out.println("Description of Task: ");
    }
    public void displayImportancePrompt(){
        System.out.println("Importance of Task (5 Highest and 1 Lowest): ");
    }
    //Remove Task
    public void displayRemovePrompt(){
        System.out.println("--Removing Task--");
        System.out.println("Index of Task to be removed: ");
    }
    //Update Task
    public void displayUpdatePrompt(){
        System.out.println("--Updating Task--");
        System.out.println("Index of Task to be update: ");
    }


    //Erros and Invalid
    public void displayInvalidOption(){
        System.out.println("Invalid Option");
    }



}
