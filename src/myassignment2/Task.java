/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myassignment2;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Task {
    String taskDescription;
    String taskName;
     int taskHours;
    String developerAssigned;
    String taskID;
     static int totalHours = 0;
     static int taskCounter = 1; // Counter to keep track of task numbers
     static ArrayList<String> taskStatusArray = new ArrayList<>();
     static ArrayList<String> taskDeveloperArray = new ArrayList<>();
     static ArrayList<String> taskNameArray = new ArrayList<>();
     static ArrayList<Integer> taskDurationArray = new ArrayList<>();

    public void getTaskName() {
        taskName = JOptionPane.showInputDialog("Please create a Task Name");
    }

    public void getDevName() {
        developerAssigned = JOptionPane.showInputDialog("Please enter the name of the developer assigned to the Task");
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
public void getTaskHours() {
       String hours = JOptionPane.showInputDialog(" Returning task hours");
            int returnedTaskHours = Integer.parseInt(hours);
    }
    public void setDeveloperAssigned(String developerAssigned) {
        this.developerAssigned = developerAssigned;
    }

    public void setTaskHours(int taskHours) {
        this.taskHours = taskHours;
        totalHours += taskHours;
    }

    public void setTaskStatus(String taskStatus) {
        taskStatusArray.add(taskStatus.toLowerCase());
    }

    public void printTaskDetails() {
        JOptionPane.showMessageDialog(null, "Status: " + taskStatusArray.get(taskStatusArray.size() - 1) + 
                     "\nDeveloper Details: " + developerAssigned + 
                        "\nTask Number: " + taskID + 
                             "\nTask Name: " + taskName + 
                              "\nTask Description: " + taskDescription + 
                              "\nTask Duration: " + taskHours);
    }

    public void createTaskID() {
        String devAssignedEnd = developerAssigned.substring(developerAssigned.length() - 3).toUpperCase();
        String taskNameFront = taskName.substring(0, 3).toUpperCase();
        StringBuilder sb = new StringBuilder();
        sb.append(taskNameFront).append(":").append(taskCounter).append(":").append(devAssignedEnd);
        taskID = sb.toString();
        taskCounter++; // Increment taskCounter
    }

    public static Task[] createTask(int chosenNumberOfTasksConverted) {
        Task[] tasks = new Task[chosenNumberOfTasksConverted];

        for (int i = 0; i < chosenNumberOfTasksConverted; i++) {
            Task maker = new Task();
            maker.setTaskName(JOptionPane.showInputDialog("Please create a Task Name"));
            maker.setDeveloperAssigned(JOptionPane.showInputDialog("Please enter the name of the developer assigned to the Task"));
            int hoursAmount = Integer.parseInt(JOptionPane.showInputDialog("How many hours is your task?"));
            maker.setTaskHours(hoursAmount);
            maker.getTaskDescription();
            maker.setTaskStatus(JOptionPane.showInputDialog("What is the Status of the task? "));
            maker.createTaskID();
            maker.printTaskDetails();
            tasks[i] = maker;

            // Add task details to the static arrays
            taskNameArray.add(maker.taskName);
            taskDeveloperArray.add(maker.developerAssigned);
            taskDurationArray.add(maker.taskHours);
            taskStatusArray.add(maker.taskStatusArray.get(maker.taskStatusArray.size() - 1));
        }
        JOptionPane.showMessageDialog(null, "Your total task hours are: " + totalHours);
        return tasks;
    }

    public void mySubMenu() {
        try {
            String selector = JOptionPane.showInputDialog("1. Create Task\n2. Show Tasks With Status Done\n3. Display Tasks With Longest Duration\n4. Search Tasks By Name\n5. Search Tasks By Developer\n6. Delete Task By Name\n7. Display All Tasks\n8. Quit");
            int selection = Integer.parseInt(selector);
EntryPage returner = new EntryPage();
            switch (selection) {
                case 1:
                    Task.createTask(Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?")));
                    mySubMenu();
                    
                case 2:
                    displayTasksWithStatusDone();
                    mySubMenu();
                    
                case 3:
                    displayTaskWithLongestDuration();
                    mySubMenu();
                    
                case 4:
                    searchTaskByName(JOptionPane.showInputDialog("Enter the task name:"));
                    mySubMenu();
                    
                case 5:
                    searchTasks(JOptionPane.showInputDialog("Enter the developer name:"));
                    mySubMenu();
                    
                case 6:
                    deleteTask(JOptionPane.showInputDialog("Enter the task name to delete:"));
                    mySubMenu();
                    
                case 7:
                    displaysAllTasks();
                    mySubMenu();
                   
                case 8:
                    JOptionPane.showMessageDialog(null, "Returning to main menu");
                    returner.myMenu();
                default:
                    JOptionPane.showMessageDialog(null, "You cannot enter that . Please try again.");
                    mySubMenu();
                    break;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    public void getTaskDescription() {
        JTextArea taskDescriptionBox = new JTextArea(9, 26);
        JScrollPane taskDescriptionBoxMaker = new JScrollPane(taskDescriptionBox);

        int boxmaker = JOptionPane.showOptionDialog(null, taskDescriptionBoxMaker, "Please Describe Your Task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (boxmaker == JOptionPane.OK_OPTION) {
            taskDescription = taskDescriptionBox.getText();
            checkTaskDescription();
        } else {
            JOptionPane.showMessageDialog(null, "Task description was not provided. Returning to menu.");
        }
    }

    public boolean checkTaskDescription() {
        if (taskDescription.length() <= 50) {
            JOptionPane.showMessageDialog(null, "Task Description successfully captured");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your description must be less than 50 characters");
            return false;
        }
    }

    public void displayTasksWithStatusDone() {
        StringBuilder result = new StringBuilder("Tasks with status 'done':\n");
        for (int i = 0; i < taskStatusArray.size(); i++) {
            if (taskStatusArray.get(i).equals("done")) {
          result.append("Developer: ").append(taskDeveloperArray.get(i))
          .append(", Task Name: ").append(taskNameArray.get(i))
             .append(", Task Duration: ").append(taskDurationArray.get(i)).append("\n");
            }
        }//same as other methods the for loop remains the focusbut the way the Arrays interact is simialr to emthods
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public void displayTaskWithLongestDuration() {
        int longestDuration = 0;
        int index = 0;
        for (int i = 0; i < taskDurationArray.size(); i++) {
            if (taskDurationArray.get(i) > longestDuration) {
                longestDuration = taskDurationArray.get(i);
                index = i;
            }//we use temporary variables within the method to help us identify the alrgest value in the array
        }
        JOptionPane.showMessageDialog(null, "Task with the longest duration:\nDeveloper: " + taskDeveloperArray.get(index) + ", Task Duration: " + longestDuration);
    }

    public void searchTaskByName(String taskName) {
        int index = taskNameArray.indexOf(taskName);
        if (index != -1) {//once again thik of reverse or goign through 
            JOptionPane.showMessageDialog(null, "Task Details:\nTask Name: " + taskName + ", Developer: " + taskDeveloperArray.get(index) + ", Task Status: " + taskStatusArray.get(index));
        } else {
            JOptionPane.showMessageDialog(null, "The task cannot be found");
        }
    }

    public void searchTasks(String developer) {
        StringBuilder result = new StringBuilder("Tasks assigned to " + developer + ":\n");
        for (int i = 0; i < taskDeveloperArray.size(); i++) {
            if (taskDeveloperArray.get(i).equals(developer)) {
                result.append("Task Name: ").append(taskNameArray.get(i))
       .append(", Task Status: ").append(taskStatusArray.get(i)).append("\n");
            }
        }//this method uses the typical equals and also concatinate
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public void deleteTask(String taskName) {
        int index = taskNameArray.indexOf(taskName);
        if (index != -1) {
            //if you see something negative one think of going in reverse or going through something
          taskNameArray.remove(index);
          taskDeveloperArray.remove(index);
            taskDurationArray.remove(index);
          taskStatusArray.remove(index);
            JOptionPane.showMessageDialog(null, "Task deleted");
        } else {
            JOptionPane.showMessageDialog(null, "This task was cannot be found");
        }
    }

    public void displaysAllTasks() {
        //the crucial thing happening is the append and how index is used
        StringBuilder result = new StringBuilder("All tasks:\n");
        for (int i = 0; i < taskNameArray.size(); i++) {
         result.append("Task Name: ").append(taskNameArray.get(i))
          .append(", Developer: ").append(taskDeveloperArray.get(i))
               .append(", Task Duration: ").append(taskDurationArray.get(i))
         .append(", Task Status: ").append(taskStatusArray.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }
}