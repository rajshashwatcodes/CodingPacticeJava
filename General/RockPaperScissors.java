import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.print("\nEnter your choice (rock, paper, scissors) or 'quit' to exit: ");
            String playerChoice = scanner.nextLine().toLowerCase();

            if (playerChoice.equals("quit")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }

            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', 'scissors', or 'quit'.");
                continue;
            }

            int computerChoiceIndex = random.nextInt(3); // 0 for rock, 1 for paper, 2 for scissors
            String computerChoice = getChoiceString(computerChoiceIndex);

            System.out.println("Computer chooses: " + computerChoice);

            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);
        }

        scanner.close();
    }

    private static String getChoiceString(int choiceIndex) {
        switch (choiceIndex) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "";
        }
    }

    private static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
