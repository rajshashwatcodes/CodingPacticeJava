import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt();

        // Calculate and display the factorial of the number
        long factorial = calculateFactorial(number);
        System.out.println("The factorial of " + number + " is: " + factorial);

        // Close the scanner
        scanner.close();
    }

    public static long calculateFactorial(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return n * calculateFactorial(n - 1); // Recursive case: n! = n * (n-1)!
        }
    }
}
