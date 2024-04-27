import java.util.Scanner;

public class GuessTheWordGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The word to be guessed
        String wordToGuess = "java";

        // Array to store the guessed characters
        char[] guessedCharacters = new char[wordToGuess.length()];
        for (int i = 0; i < guessedCharacters.length; i++) {
            guessedCharacters[i] = '_'; // Initialize to underscores
        }

        // Number of attempts allowed
        int attempts = 5;

        // Play the game
        while (attempts > 0 && !isWordGuessed(guessedCharacters)) {
            // Display the word with guessed characters
            System.out.println("Word: " + String.valueOf(guessedCharacters));

            // Prompt the user to guess a character
            System.out.print("Guess a character: ");
            char guess = scanner.next().charAt(0);

            // Check if the guessed character is in the word
            boolean isGuessedCorrectly = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedCharacters[i] = guess;
                    isGuessedCorrectly = true;
                }
            }

            // Decrement attempts if the guess was incorrect
            if (!isGuessedCorrectly) {
                attempts--;
                System.out.println("Incorrect guess! Attempts left: " + attempts);
            }
        }

        // Display the result
        if (isWordGuessed(guessedCharacters)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Out of attempts! The word was: " + wordToGuess);
        }

        scanner.close();
    }

    // Method to check if the word has been guessed
    public static boolean isWordGuessed(char[] guessedCharacters) {
        for (char c : guessedCharacters) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
