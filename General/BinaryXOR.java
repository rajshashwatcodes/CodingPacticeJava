public class BinaryXOR {

    // Function to perform XOR on two binary strings
    private static String binaryXOR(String binary1, String binary2) {
        // Ensure that both binary strings have the same length
        int maxLength = Math.max(binary1.length(), binary2.length());
        binary1 = String.format("%" + maxLength + "s", binary1).replace(' ', '0');
        binary2 = String.format("%" + maxLength + "s", binary2).replace(' ', '0');

        // Perform XOR operation
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            result.append(binary1.charAt(i) ^ binary2.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String binaryString1 = "110010";
        String binaryString2 = "101101";

        String result = binaryXOR(binaryString1, binaryString2);

        System.out.println("Binary XOR Result: " + result);
    }
}
