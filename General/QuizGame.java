import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    public Question(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizGame {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Question> questions = new ArrayList<>();
    private static int score = 0;

    public static void main(String[] args) {
        initializeQuestions();

        System.out.println("Welcome to the Quiz Game!");

        for (Question question : questions) {
            presentQuestion(question);
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
        if (score == questions.size()) {
            System.out.println("Congratulations! You got all the questions correct!");
        } else {
            System.out.println("Keep practicing to improve your score!");
        }
    }

    private static void initializeQuestions() {
        List<String> options1 = new ArrayList<>();
        options1.add("A) Java");
        options1.add("B) Python");
        options1.add("C) C++");
        options1.add("D) JavaScript");
        questions.add(new Question("What programming language is this?", options1, "A) Java"));

        List<String> options2 = new ArrayList<>();
        options2.add("A) Lion");
        options2.add("B) Tiger");
        options2.add("C) Bear");
        options2.add("D) Elephant");
        questions.add(new Question("Which animal is known as the king of the jungle?", options2, "A) Lion"));

        // Add more questions as needed
    }

    private static void presentQuestion(Question question) {
        System.out.println("\n" + question.getQuestionText());
        List<String> options = question.getOptions();
        Collections.shuffle(options); // Shuffle options for randomness
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();
        if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
        }
    }
}
