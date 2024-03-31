import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class InventoryManagementSystem {
    private static List<Item> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Inventory");
            System.out.println("4. Search Item by Name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    removeItem(scanner);
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    searchItemByName(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        String name = scanner.next();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        inventory.add(new Item(name, quantity));
        System.out.println("Item added successfully.");
    }

    private static void removeItem(Scanner scanner) {
        System.out.print("Enter item name to remove: ");
        String name = scanner.next();
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                inventory.remove(item);
                System.out.println("Item removed successfully.");
                return;
            }
        }
        System.out.println("Item not found in the inventory.");
    }

    private static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory:");
        for (Item item : inventory) {
            System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity());
        }
    }

    private static void searchItemByName(Scanner scanner) {
        System.out.print("Enter item name to search: ");
        String name = scanner.next();
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("Item found - Name: " + item.getName() + ", Quantity: " + item.getQuantity());
                return;
            }
        }
        System.out.println("Item not found in the inventory.");
    }
}
