import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View All Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsComplete();
                    break;
                case 3:
                    viewAllTasks();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting the Task Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully.");
    }

    private static void markTaskAsComplete() {
        System.out.print("Enter index of task to mark as complete: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    private static void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("All Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " - " + (task.isCompleted() ? "Completed" : "Incomplete"));
            }
        }
    }

    private static void removeTask() {
        System.out.print("Enter index of task to remove: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }
}
