import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"JAVA", "PYTHON", "CLOUD", "COMPUTER", "PROGRAMMING"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");

        String wordToGuess = selectRandomWord();
        StringBuilder guessedLetters = new StringBuilder(wordToGuess.length());
        int incorrectGuesses = 0;

        // Initialize guessedLetters with underscores
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedLetters.append('_');
        }

        while (incorrectGuesses < MAX_TRIES && guessedLetters.indexOf("_") != -1) {
            System.out.println("\nWord to guess: " + guessedLetters);
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toUpperCase().charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("Invalid input! Please enter a letter.");
                continue;
            }

            if (wordToGuess.indexOf(guess) != -1) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedLetters.setCharAt(i, guess);
                    }
                }
                System.out.println("Correct guess!");
            } else {
                incorrectGuesses++;
                System.out.println("Incorrect guess! You have " + (MAX_TRIES - incorrectGuesses) + " tries left.");
            }
        }

        if (incorrectGuesses == MAX_TRIES) {
            System.out.println("\nYou've run out of tries! The word was: " + wordToGuess);
        } else {
            System.out.println("\nCongratulations! You've guessed the word: " + wordToGuess);
        }

        scanner.close();
    }

    private static String selectRandomWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }
}
