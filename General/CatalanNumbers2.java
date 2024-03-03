import java.util.HashMap;

public class CatalanNumbers2 {
    // Memoization to store previously computed Catalan numbers
    private static HashMap<Integer, Long> memo = new HashMap<>();

    public static long catalan(int n) {
        // Base case: If n is 0 or 1, return 1
        if (n <= 1) {
            return 1;
        }
        
        // Check if the value has already been computed and stored in memo
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // Calculate Catalan number recursively and store it in memo
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += catalan(i) * catalan(n - i - 1);
        }
        memo.put(n, result);
        
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Catalan number for n = " + n + " is " + catalan(n));
    }
}
