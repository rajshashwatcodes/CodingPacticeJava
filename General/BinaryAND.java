public class BinaryAND {

    // Function to perform AND on two binary strings
    private static String binaryAND(String binary1, String binary2) {
        // Ensure that both binary strings have the same length
        int maxLength = Math.max(binary1.length(), binary2.length());
        binary1 = String.format("%" + maxLength + "s", binary1).replace(' ', '0');
        binary2 = String.format("%" + maxLength + "s", binary2).replace(' ', '0');

        // Perform AND operation
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            result.append(binary1.charAt(i) == '1' && binary2.charAt(i) == '1' ? '1' : '0');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String binaryString1 = "110010";
        String binaryString2 = "101101";

        String result = binaryAND(binaryString1, binaryString2);

        System.out.println("Binary AND Result: " + result);
    }
}
