public class GetIthBit {
    public static void main(String[] args) {
        int number = 25; // Example number
        int position = 3; // Example position (0-based index)

        int ithBit = getIthBit(number, position);
        System.out.println("The " + position + "th bit is: " + ithBit);
    }

    // Function to get the ith bit of a number
    private static int getIthBit(int num, int i) {
        // Shifting 1 to the ith position and performing bitwise AND with the number
        return (num & (1 << i)) == 0 ? 0 : 1;
    }
}
