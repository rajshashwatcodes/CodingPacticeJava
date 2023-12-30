import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();

        // Convert decimal to binary
        String binaryString = decimalToBinary(decimalNumber);

        System.out.println("Binary representation: " + binaryString);

        scanner.close();
    }

    // Function to convert decimal to binary
    static String decimalToBinary(int decimalNumber) {
        // Check for special case when the number is 0
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder binaryString = new StringBuilder();

        // Keep dividing the number by 2 and appending remainders to the binary string
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binaryString.insert(0, remainder); // Insert at the beginning of the string
            decimalNumber /= 2;
        }

        return binaryString.toString();
    }
}
