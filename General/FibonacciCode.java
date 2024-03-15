import java.util.Scanner;

public class FibonacciCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = 0;
        
        while (limit <= 0) {
            System.out.print("Enter a positive integer limit for Fibonacci sequence: ");
            try {
                limit = scanner.nextInt();
                if (limit <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        
        System.out.println("Fibonacci sequence up to " + limit + ":");
        for (int i = 0; i < limit; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
