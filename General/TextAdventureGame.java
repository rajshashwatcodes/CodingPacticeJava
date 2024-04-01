import java.util.Scanner;

public class TextAdventureGame {
    private static Scanner scanner = new Scanner(System.in);
    private static int currentRoom = 1; // Starting room

    public static void main(String[] args) {
        System.out.println("Welcome to the Text Adventure Game!");

        while (true) {
            displayRoomDescription();
            displayOptions();
            int choice = scanner.nextInt();
            handleChoice(choice);
        }
    }

    private static void displayRoomDescription() {
        switch (currentRoom) {
            case 1:
                System.out.println("You are in a dark room. You can see two doors - one on your left and one on your right.");
                break;
            case 2:
                System.out.println("You entered the room on the left. There's a key on the table.");
                break;
            case 3:
                System.out.println("You entered the room on the right. You see a chest in the corner.");
                break;
            case 4:
                System.out.println("You found the exit! Congratulations, you won the game!");
                System.exit(0);
                break;
        }
    }

    private static void displayOptions() {
        switch (currentRoom) {
            case 1:
                System.out.println("1. Go left");
                System.out.println("2. Go right");
                break;
            case 2:
                System.out.println("1. Take the key");
                System.out.println("2. Go back");
                break;
            case 3:
                System.out.println("1. Open the chest");
                System.out.println("2. Go back");
                break;
        }
        System.out.print("Enter your choice: ");
    }

    private static void handleChoice(int choice) {
        switch (currentRoom) {
            case 1:
                if (choice == 1) {
                    currentRoom = 2;
                } else if (choice == 2) {
                    currentRoom = 3;
                }
                break;
            case 2:
                if (choice == 1) {
                    System.out.println("You took the key.");
                    // Handle key logic
                } else if (choice == 2) {
                    currentRoom = 1;
                }
                break;
            case 3:
                if (choice == 1) {
                    System.out.println("You opened the chest and found a treasure!");
                    currentRoom = 4; // Set to exit room
                } else if (choice == 2) {
                    currentRoom = 1;
                }
                break;
        }
    }
}
