/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package myassignment2;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TaskTest {

    private Task task1, task2, task3, task4;
    private List<Task> tasks;

    @Before
    public void setUp() {
        // Clear static arrays before each test
        Task.taskNameArray.clear();
        Task.taskDeveloperArray.clear();
        Task.taskDurationArray.clear();
        Task.taskStatusArray.clear();
        Task.totalHours = 0;
        Task.taskCounter = 1;

        // Initialize the tasks
        task1 = new Task();
        task1.setTaskName("Create Login");
        task1.setDeveloperAssigned("Mike Smith");
        task1.setTaskHours(5);
        task1.setTaskStatus("To Do");
        task1.createTaskID();
        addTaskToStaticArrays(task1);

        task2 = new Task();
        task2.setTaskName("Create Add Features");
        task2.setDeveloperAssigned("Edward Harrison");
        task2.setTaskHours(8);
        task2.setTaskStatus("Doing");
        task2.createTaskID();
        addTaskToStaticArrays(task2);

        task3 = new Task();
        task3.setTaskName("Create Reports");
        task3.setDeveloperAssigned("Samantha Paulson");
        task3.setTaskHours(2);
        task3.setTaskStatus("Done");
        task3.createTaskID();
        addTaskToStaticArrays(task3);

        task4 = new Task();
        task4.setTaskName("Add Arrays");
        task4.setDeveloperAssigned("Glenda Oberholzer");
        task4.setTaskHours(11);
        task4.setTaskStatus("To Do");
        task4.createTaskID();
        addTaskToStaticArrays(task4);

        // Add tasks to the list
        tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
    }

    private void addTaskToStaticArrays(Task task) {
        // Helper method to add task details to the static arrays
        Task.taskNameArray.add(task.taskName);
        Task.taskDeveloperArray.add(task.developerAssigned);
        Task.taskDurationArray.add(task.taskHours);
        Task.taskStatusArray.add(Task.taskStatusArray.get(Task.taskStatusArray.size() - 1));
        Task.totalHours += task.taskHours;
    }

    @Test
    public void testDeleteTask() {
        // Test deleting a task by name
        task1.deleteTask("Create Login");
        assertFalse(Task.taskNameArray.contains("Create Login"));
    }

    @Test
    public void testDisplaysAllTasks() {
        // Test displaying all tasks
        task1.displaysAllTasks();
        assertEquals(4, Task.taskNameArray.size());
    }

    @Test
    public void testSearchTasks() {
        // Test searching tasks by developer name
        task1.searchTasks("Edward Harrison");
        assertTrue(Task.taskDeveloperArray.contains("Edward Harrison"));
    }

    @Test
    public void testDisplayTaskWithLongestDuration() {
        // Test displaying task with the longest duration
        task1.displayTaskWithLongestDuration();
        assertEquals(11, (int) Task.taskDurationArray.stream().max(Integer::compare).orElse(0));
    }

    @Test
    public void testGetTaskName() {
     
    }

    @Test
    public void testGetDevName() {
       
    }

    @Test
    public void testGetTaskHours() {
      
    }

    @Test
    public void testCheckTaskDescription() {
        // Test checking task description
        task1.taskDescription = "Create a login feature";
        boolean result = task1.checkTaskDescription();
        boolean expresult = true;
        assertEquals(expresult, result);
    }

    @Test
    public void testGetTaskDescription() {
      
    }

    @Test
    public void testPrintTaskDetails() {
   
    }

    @Test
    public void testCreateTaskID() {
        // Test creating task ID
        Task task = new Task();
        task.taskName = "Checkout";
        task.developerAssigned = "Dude";
        task.createTaskID();
        String expected = "CHE:5:UDE";
        assertEquals(expected, task.taskID);
    }

    @Test
    public void testCreateTask() {
      
    }

    @Test
    public void testTotalHoursCalculation() {
       
    }
}