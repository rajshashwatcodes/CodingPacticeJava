import java.util.Arrays;
import java.util.Comparator;

class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class MinimumLengthChain {

    public static int minChainLength(Pair[] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        // Sort the pairs based on the second element
        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair.second));

        int n = pairs.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i].first > pairs[j].second && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxChainLength = Arrays.stream(dp).max().orElse(0);
        return maxChainLength;
    }

    public static void main(String[] args) {
        Pair[] pairs = {
                new Pair(5, 24),
                new Pair(15, 25),
                new Pair(27, 40),
                new Pair(50, 60)
        };

        int result = minChainLength(pairs);
        System.out.println("Minimum Length Chain: " + result);
    }
}
