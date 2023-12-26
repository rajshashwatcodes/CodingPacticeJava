public class PrimeNumbersDescending {

    public static void main(String[] args) {
        System.out.println("Prime numbers in decreasing order between 1 and 100:");

        // Loop through numbers in reverse order (from 100 to 1)
        for (int i = 100; i >= 2; i--) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Function to check if a number is prime
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        // Check for factors up to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
