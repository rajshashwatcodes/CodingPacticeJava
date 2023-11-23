public class BinomialCoefficient {

    // Function to calculate the factorial of a number
    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Function to calculate the binomial coefficient C(n, k)
    private static long binomialCoefficient(int n, int k) {
        if (k < 0 || k > n) {
            return 0; // Invalid input, as there are no combinations for these values
        }

        // C(n, k) = n! / (k! * (n - k)!)
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        long result = binomialCoefficient(n, k);

        System.out.println("Binomial Coefficient C(" + n + ", " + k + ") is: " + result);
    }
}
