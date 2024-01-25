import java.util.HashSet;
import java.util.Set;

public class UniqueSubstrings {

    public static int countUniqueSubstrings(String s) {
        int n = s.length();
        Set<String> uniqueSubstrings = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // Extract the substring from index i to j-1
                String substring = s.substring(i, j);
                uniqueSubstrings.add(substring);
            }
        }

        return uniqueSubstrings.size();
    }

    public static void main(String[] args) {
        String input = "abc";
        int result = countUniqueSubstrings(input);
        System.out.println("Count of unique substrings: " + result);  // Output: 6
    }
}
