public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // Create a DP table to store the matching results
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Empty string and empty pattern match
        dp[0][0] = true;
        
        // Handling the case where the pattern starts with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Dynamic Programming approach to fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        WildcardMatching matcher = new WildcardMatching();

        String s1 = "adceb";
        String p1 = "*a*b";
        System.out.println(matcher.isMatch(s1, p1)); // Output: true
        
        String s2 = "acdcb";
        String p2 = "a*c?b";
        System.out.println(matcher.isMatch(s2, p2)); // Output: false
    }
}
