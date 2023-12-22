public class ClearLastIBits {
    public static void main(String[] args) {
        int num = 28; // Example number
        int i = 2;    // Number of bits to clear from the least significant side

        // Create a mask with the last i bits set to 0 and the rest set to 1
        int mask = ~((1 << i) - 1);

        // Use bitwise AND with the mask to clear the last i bits
        int result = num & mask;

        System.out.println("Original number: " + num);
        System.out.println("Number after clearing the last " + i + " bits: " + result);
    }
}
