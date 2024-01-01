import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = findPermutations(input);

        System.out.println("Permutations of " + input + ":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    // Function to find all permutations of a string
    static List<String> findPermutations(String str) {
        List<String> result = new ArrayList<>();
        findPermutationsHelper("", str, result);
        return result;
    }

    // Helper function for recursive permutation generation
    static void findPermutationsHelper(String prefix, String remaining, List<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix);  // Found one permutation
        } else {
            for (int i = 0; i < n; i++) {
                // Recursively generate permutations for the remaining characters
                findPermutationsHelper(prefix + remaining.charAt(i),
                                       remaining.substring(0, i) + remaining.substring(i + 1),
                                       result);
            }
        }
    }
}
