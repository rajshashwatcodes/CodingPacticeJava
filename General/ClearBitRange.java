public class ClearBitRange {
    public static void main(String[] args) {
        int num = 255;   // Example number
        int start = 4;    // Starting position of the range (0-based index)
        int end = 7;      // Ending position of the range (0-based index)

        // Create a mask with the bits in the range set to 0 and the rest set to 1
        int mask = ~(((1 << (end - start + 1)) - 1) << start);

        // Use bitwise AND with the mask to clear the bits in the specified range
        int result = num & mask;

        System.out.println("Original number: " + num);
        System.out.println("Number after clearing bits in the range [" + start + ", " + end + "]: " + result);
    }
}
