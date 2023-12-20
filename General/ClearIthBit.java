public class ClearIthBit {
    public static void main(String[] args) {
        int num = 12; // Example number
        int position = 2; // Position of the bit to clear (0-based index)

        // Clear the ith bit using bitwise AND with the complement of (1 << position)
        int result = num & ~(1 << position);

        System.out.println("Original number: " + num);
        System.out.println("Number after clearing the " + position + "th bit: " + result);
    }
}
