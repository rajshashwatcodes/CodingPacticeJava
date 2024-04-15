import java.util.Random;
import java.util.Scanner;

public class RollingForTreasure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rolling for Treasure!");

        while (true) {
            System.out.print("Enter the target number (2-12) or 0 to quit: ");
            int targetNumber = scanner.nextInt();

            if (targetNumber == 0) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }

            if (targetNumber < 2 || targetNumber > 12) {
                System.out.println("Invalid target number. Please enter a number between 2 and 12.");
                continue;
            }

            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " and " + die2);
            System.out.println("Sum of the numbers rolled: " + sum);

            if (sum == targetNumber) {
                System.out.println("Congratulations! You win a treasure!");
            } else {
                System.out.println("Sorry, you didn't roll the target number. Try again!");
            }
        }

        scanner.close();
    }
}
