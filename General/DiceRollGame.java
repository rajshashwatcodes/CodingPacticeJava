import java.util.Random;
import java.util.Scanner;

public class DiceRollGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Dice Rolling Game!");

        while (true) {
            System.out.println("\nDo you want to roll the dice? (yes/no)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("yes")) {
                int diceValue = random.nextInt(6) + 1; // Generating random number between 1 and 6
                System.out.println("You rolled a " + diceValue + "!");
                if (diceValue == 6) {
                    System.out.println("Congratulations! You rolled a 6. You win!");
                } else {
                    System.out.println("Sorry, you didn't roll a 6. Try again!");
                }
            } else if (choice.equals("no")) {
                System.out.println("Thank you for playing! Goodbye!");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }

        scanner.close();
    }
}
