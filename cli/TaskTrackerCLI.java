package task.tracker.cli;

import java.util.Scanner;

public class TaskTrackerCLI
{
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println("\nTask Tracker CLI");
            System.out.println("1. Add Task");
            System.out.println("2. List tasks");
            System.out.println("3. Update task status");
            System.out.println("4. Remove task");
            System.out.println("5. Quit");

            System.out.println("Choose an option:");
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    addTask();
                    break;
                case "2":
                    listTasks();
                    break;
                case "3":
                    updateTaskStatus();
                    break;
                case "4":
                    removeTask();
                    break;
                case "5":
                    System.out.println("Exiting Task Tracker.Goodbye!!!");
            }


        }
    }


    //add a task
    private static void addTask() {
        System.out.println("Enter the task description:");
        String description = scanner.nextLine();
        taskManager.addTask(description);
        System.out.println("Task added successfully.");
    }

    //List all Tasks
    private static void listTasks() {
        taskManager.listTasks();
    }


    //update task status
    private static void updateTaskStatus() {
        listTasks();
        System.out.println("Enter the task number to update status:");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter new status (pending/in progress/completed):");
        String status = scanner.nextLine().toLowerCase();
        taskManager.updateTaskStatus(taskNumber,status);
        System.out.println("Task status updated.");

    }

    //Remove a task
    private static void removeTask() {
        listTasks();
        System.out.println("Enter the task number to remove:");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        taskManager.removeTask(taskNumber);
        System.out.println("Task removed.");
    }

}
