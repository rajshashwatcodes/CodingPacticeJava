public class MostCommonPrefix {

    public static String findMostCommonPrefix(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        // Find the minimum length among all words
        int minLength = Integer.MAX_VALUE;
        for (String word : words) {
            minLength = Math.min(minLength, word.length());
        }

        StringBuilder commonPrefix = new StringBuilder();

        // Iterate through each character position up to the minimum length
        for (int i = 0; i < minLength; i++) {
            char currentChar = words[0].charAt(i);

            // Check if the character is common in all words
            for (String word : words) {
                if (word.charAt(i) != currentChar) {
                    return commonPrefix.toString();
                }
            }

            // If the character is common, append it to the common prefix
            commonPrefix.append(currentChar);
        }

        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        String[] words1 = {"flower", "flow", "flight"};
        System.out.println("Most common prefix: " + findMostCommonPrefix(words1));  // Output: "fl"

        String[] words2 = {"dog", "racecar", "car"};
        System.out.println("Most common prefix: " + findMostCommonPrefix(words2));  // Output: ""
    }
}
