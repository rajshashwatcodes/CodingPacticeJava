import java.util.Scanner;

public class StringConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String originalString = scanner.nextLine();

        // Convert the string to upper case
        String convertedString = originalString.toUpperCase();

        // Display the original and converted strings
        System.out.println("Original String: " + originalString);
        System.out.println("Converted String: " + convertedString);

        scanner.close();
    }
}
