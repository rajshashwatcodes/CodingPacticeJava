import java.util.ArrayList;
import java.util.Scanner;

// Task class representing a single to-do item
class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void complete() {
        isCompleted = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + description;
    }
}

// ToDoList class to manage the list of tasks
class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).complete();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

// Main class to interact with the user
public class ToDoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();
        String command;

        System.out.println("Welcome to the To-Do List App!");
        System.out.println("Available commands: add, remove, complete, view, quit");

        do {
            System.out.print("\nEnter a command: ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter a task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    System.out.println("Task added.");
                    break;

                case "remove":
                    System.out.print("Enter the task number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    toDoList.removeTask(removeIndex);
                    System.out.println("Task removed.");
                    break;

                case "complete":
                    System.out.print("Enter the task number to complete: ");
                    int completeIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    toDoList.completeTask(completeIndex);
                    System.out.println("Task marked as complete.");
                    break;

                case "view":
                    System.out.println("\nYour to-do list:");
                    toDoList.viewTasks();
                    break;

                case "quit":
                    System.out.println("Exiting the To-Do List App. Goodbye!");
                    break;

                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        } while (!command.equals("quit"));

        scanner.close();
    }
}
