import java.util.Scanner;

public class CountSetBits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Count set bits and display the result
        int count = countSetBits(number);
        System.out.println("Number of set bits in " + number + ": " + count);

        scanner.close();
    }

    // Function to count set bits in a number
    static int countSetBits(int n) {
        int count = 0;

        // Loop through each bit in the number
        while (n > 0) {
            // Increment count if the rightmost bit is set (equals 1)
            count += n & 1;
            
            // Right shift the number to check the next bit
            n >>= 1;
        }

        return count;
    }
}
