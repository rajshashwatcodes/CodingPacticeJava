public class RemoveDuplicates {
    
    public static String removeDuplicates(String input) {
        if (input == null || input.length() <= 1) {
            return input; // No duplicates to remove
        }

        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // Assuming ASCII characters

        for (char ch : input.toCharArray()) {
            if (!seen[ch]) {
                result.append(ch);
                seen[ch] = true;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "programming";

        String result = removeDuplicates(input);

        System.out.println("Original String: " + input);
        System.out.println("String after removing duplicates: " + result);
    }
}
