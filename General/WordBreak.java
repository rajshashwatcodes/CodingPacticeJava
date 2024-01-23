import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        // dp[i] represents if the substring s[0...i] can be segmented into words in the wordDict
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string is always valid

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        Set<String> wordDict1 = new HashSet<>();
        wordDict1.add("leet");
        wordDict1.add("code");
        System.out.println("Example 1: " + wordBreak(s1, wordDict1)); // Output: true

        String s2 = "applepenapple";
        Set<String> wordDict2 = new HashSet<>();
        wordDict2.add("apple");
        wordDict2.add("pen");
        System.out.println("Example 2: " + wordBreak(s2, wordDict2)); // Output: true

        String s3 = "catsandog";
        Set<String> wordDict3 = new HashSet<>();
        wordDict3.add("cats");
        wordDict3.add("dog");
        wordDict3.add("sand");
        wordDict3.add("and");
        wordDict3.add("cat");
        System.out.println("Example 3: " + wordBreak(s3, wordDict3)); // Output: false
    }
}
