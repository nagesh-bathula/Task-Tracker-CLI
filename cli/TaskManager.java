package task.tracker.cli;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TaskManager
{
    private static final String TASKS_FILE = "tasks.dat";
    private ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = loadTasks();
    }

    // Add a new task
    public void addTask(String description) {
        tasks.add(new Task(description));
        saveTasks();
    }

    // List all tasks
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
    }

    // Update task status
    public void updateTaskStatus(int taskNumber, String status) {
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task Number.");
            return;
        }
        Task task = tasks.get(taskNumber - 1);
        task.setStatus(status);
        saveTasks();
    }

    // Remove a task
    public void removeTask(int taskNumber) {
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task Number.");
            return;
        }
        tasks.remove(taskNumber - 1);
        saveTasks();
    }

    // Save the tasks into file
    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TASKS_FILE))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Load tasks from file
    private ArrayList<Task> loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TASKS_FILE))) {
            return (ArrayList<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Returning an empty list if file does not exist or cannot be read
            return new ArrayList<>();
        }
    }
}
