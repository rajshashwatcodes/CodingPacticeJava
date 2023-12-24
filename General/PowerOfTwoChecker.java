import java.util.Scanner;

public class PowerOfTwoChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the number is a power of 2
        if (isPowerOfTwo(number)) {
            System.out.println(number + " is a power of 2.");
        } else {
            System.out.println(number + " is not a power of 2.");
        }

        scanner.close();
    }

    // Function to check if a number is a power of 2
    static boolean isPowerOfTwo(int n) {
        // A number is a power of 2 if and only if it has exactly one bit set to 1
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
