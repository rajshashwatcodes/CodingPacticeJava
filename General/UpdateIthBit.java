public class UpdateIthBit {
    public static void main(String[] args) {
        int num = 12; // Example number
        int position = 2; // Position of the bit to update (0-based index)
        int newValue = 1; // The new value (0 or 1) to set at the ith position

        // Clear the ith bit using bitwise AND with the complement of (1 << position)
        // Then set the ith bit to newValue using bitwise OR
        int result = (num & ~(1 << position)) | (newValue << position);

        System.out.println("Original number: " + num);
        System.out.println("Number after updating the " + position + "th bit to " + newValue + ": " + result);
    }
}
