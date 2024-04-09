import java.util.Scanner;

public class QuizGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the questions and answers
        String[] questions = {
            "What is the capital of France?",
            "Who wrote 'Romeo and Juliet'?",
            "What is the chemical symbol for water?"
        };

        String[] options = {
            "A) London\tB) Paris\tC) Rome",
            "A) William Shakespeare\tB) Jane Austen\tC) Charles Dickens",
            "A) W\tB) O\tC) H2O"
        };

        String[] answers = {"B", "A", "C"};

        // Initialize score
        int score = 0;

        // Start the quiz
        System.out.println("Welcome to the Quiz Game!");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            System.out.println(options[i]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + answers[i]);
            }
        }

        // Display final score
        System.out.println("\nQuiz completed! Your score: " + score + "/" + questions.length);

        scanner.close();
    }
}
