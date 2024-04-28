import java.util.Random;
import java.util.Scanner;

public class RollTheDiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Dice Roll Game!");

        while (true) {
            // Roll two dice
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;

            System.out.println("You rolled: " + dice1 + " and " + dice2);
            System.out.println("Sum of the numbers: " + (dice1 + dice2));

            System.out.print("Do you want to roll again? (yes/no): ");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
