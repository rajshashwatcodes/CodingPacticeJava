public class FibonacciAnalysis {

    public static void main(String[] args) {
        int n = 10; // Change this to the desired number of Fibonacci numbers to generate and analyze

        System.out.println("Generating and analyzing the first " + n + " Fibonacci numbers:");
        
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int fibonacciNumber = fibonacci(i);
            System.out.print(fibonacciNumber + " ");
        }
        long endTime = System.nanoTime();
        
        long elapsedTime = endTime - startTime;
        System.out.println("\nTime taken to generate " + n + " Fibonacci numbers: " + (elapsedTime / 1000000) + " milliseconds");
        
        double averageTime = (double) elapsedTime / n;
        System.out.println("Average time to generate a Fibonacci number: " + averageTime + " milliseconds");
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
