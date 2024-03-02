public class CatalanNumbers {
    public static long catalan(int n) {
        if (n <= 1) {
            return 1;
        }
        
        // Create an array to store Catalan numbers
        long[] catalan = new long[n + 1];
        
        // Initialize the first two values
        catalan[0] = 1;
        catalan[1] = 1;
        
        // Fill the array using dynamic programming
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        
        return catalan[n];
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Catalan number for n = " + n + " is " + catalan(n));
    }
}
