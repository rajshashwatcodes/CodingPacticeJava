import java.util.Scanner;

public class TextAdventureGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a dark and mysterious dungeon.");

        // Start the game
        exploreDungeon(scanner);

        System.out.println("Thanks for playing the Text Adventure Game!");
        scanner.close();
    }

    public static void exploreDungeon(Scanner scanner) {
        System.out.println("\nYou see two doors in front of you. Do you go left (L) or right (R)?");
        char choice = scanner.next().charAt(0);

        if (choice == 'L') {
            // Left path
            System.out.println("\nYou enter a room filled with treasure chests. You find a key.");
            System.out.println("What do you do next?");
            System.out.println("A. Open one of the treasure chests.");
            System.out.println("B. Return to the previous room.");
            char action = scanner.next().charAt(0);

            if (action == 'A') {
                System.out.println("\nYou open a chest and find a pile of gold coins!");
            } else {
                System.out.println("\nYou return to the previous room.");
            }
        } else {
            // Right path
            System.out.println("\nYou enter a room with a locked door.");
            System.out.println("What do you do next?");
            System.out.println("A. Try to pick the lock.");
            System.out.println("B. Search for a key.");
            char action = scanner.next().charAt(0);

            if (action == 'A') {
                System.out.println("\nYou attempt to pick the lock, but it's too difficult.");
                System.out.println("You hear footsteps approaching. You hide!");
                System.out.println("A guard walks in, but doesn't notice you.");
            } else {
                System.out.println("\nYou search the room and find a key hidden behind a painting.");
                System.out.println("You use the key to unlock the door and proceed.");
            }
        }

        // Continue exploring or end the game
        System.out.println("\nDo you want to continue exploring? (Y/N)");
        char continueExploring = scanner.next().charAt(0);
        if (continueExploring == 'Y') {
            exploreDungeon(scanner);
        } else {
            System.out.println("\nYou decide to leave the dungeon and end your adventure.");
        }
    }
}
