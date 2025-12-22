package com.pengoo.boundary;

import com.pengoo.control.CLITaskController;
import com.pengoo.view.DisplayText;

import java.util.Scanner;

// for inputs of user
public class TaskMenu {
    private CLITaskController cliTaskController = new CLITaskController();
    private DisplayText displayText = new DisplayText();
    private Scanner scanner = new Scanner(System.in);

    public void run(){
        boolean running = true;

        while (running){
            displayText.displayMenu();
            int choice = readMenuChoice(1,7);

            switch (choice){
                case 1:
                    displayText.displayAllTasks(cliTaskController.getAllTasks());
                    break;
                case 2:
                    handleAddTask();
                    break;
                case 3:
                    handleRemoveTask();
                    break;
                case 4:
                    handleUpdateTask();
                    break;
                case 5:
                    handlePointsLevel();
                    break;
                case 6:
                    undo();
                    break;
                case 7:
                    running = false;
                    break;
            }
        }
    }


    //helpers



    //for task adding
    private void handleAddTask(){
        displayText.displayTitlePrompt();
        String title = scanner.nextLine();
        displayText.displayDescriptionPrompt();
        String description = scanner.nextLine();
        displayText.displayImportancePrompt();
        int importance = readImportance(1,5);

        cliTaskController.addTask(title,description,importance);
    }
    //for remove task
    private void handleRemoveTask(){
        displayText.displayRemovePrompt();
        int index = readInt();
        cliTaskController.removeTask(index);
    }
    private void handleUpdateTask(){
        displayText.displayUpdatePrompt();
        int index = readInt();
        cliTaskController.updateTask(index);
    }
    private void handlePointsLevel(){

    }
    private void undo(){

    }




    //for menu check
    private int readMenuChoice(int min, int max){
        while(true){
            if(scanner.hasNextInt()){
                int choice = scanner.nextInt();
                scanner.nextLine();
                if(choice>=min || choice<=max){
                    return  choice;
                }
            }
            else {
                scanner.nextLine();
            }
            displayText.displayInvalidOption();
        }
    }
    // for importance
    private int readImportance(int min, int max){
        while(true){
            if(scanner.hasNextInt()){
                int importance = scanner.nextInt();
                scanner.nextLine();
                if(importance >=min || importance <=max){
                    return importance;
                }
            }
            else {
                scanner.nextLine();
            }
            displayText.displayInvalidOption();
        }
    }

    //validate if int
    private int readInt(){
        int result;
        while(true){
            String index = scanner.nextLine();
            try{
                result = Integer.parseInt(index);
                break;
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid integer.");
            }
        }
        return result;
    }





}
