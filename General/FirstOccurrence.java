import java.util.Scanner;

public class FirstOccurrence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array elements
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Input the element to find
        System.out.print("Enter the element to find: ");
        int target = scanner.nextInt();

        // Find the first occurrence index
        int firstOccurrenceIndex = findFirstOccurrence(array, target);

        if (firstOccurrenceIndex != -1) {
            System.out.println("The first occurrence of " + target + " is at index: " + firstOccurrenceIndex);
        } else {
            System.out.println(target + " is not present in the array.");
        }

        scanner.close();
    }

    // Function to find the first occurrence index in an array
    static int findFirstOccurrence(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return the index of the first occurrence
            }
        }
        return -1; // Return -1 if the element is not found
    }
}
