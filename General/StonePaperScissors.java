import java.util.Scanner;
import java.util.Random;

public class StonePaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Stone, Paper, Scissors!");

        while (true) {
            // Prompt user to choose an option
            System.out.print("\nEnter your choice (stone, paper, or scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            // Generate computer's choice randomly
            int computerChoiceIndex = random.nextInt(3); // 0 for stone, 1 for paper, 2 for scissors
            String[] options = {"stone", "paper", "scissors"};
            String computerChoice = options[computerChoiceIndex];

            System.out.println("Computer chooses: " + computerChoice);

            // Determine the winner
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("stone") && computerChoice.equals("scissors")) ||
                       (userChoice.equals("paper") && computerChoice.equals("stone")) ||
                       (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("Congratulations! You win!");
            } else {
                System.out.println("Computer wins!");
            }

            // Ask if the user wants to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }
}
