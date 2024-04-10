import java.util.Scanner;

public class GuessTheName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretName = "Java"; // The name to be guessed
        int maxAttempts = 3; // Maximum number of attempts allowed
        int attempts = 0; // Counter for attempts

        System.out.println("Welcome to the Guess the Name game!");
        System.out.println("You have " + maxAttempts + " attempts to guess the name.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            if (guess.equalsIgnoreCase(secretName)) {
                System.out.println("Congratulations! You guessed the name correctly.");
                break;
            } else {
                System.out.println("Incorrect guess. Try again.");
                attempts++;
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct name was: " + secretName);
        }

        scanner.close();
    }
}
