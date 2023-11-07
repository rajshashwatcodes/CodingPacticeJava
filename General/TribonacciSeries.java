public class TribonacciSeries {
    public static void main(String[] args) {
        int n = 20; // Change this to the desired value for 'n'
        int[] tribonacci = new int[n];

        // Initialize the first three elements
        tribonacci[0] = 0;
        tribonacci[1] = 0;
        tribonacci[2] = 1;

        // Calculate the Tribonacci series
        for (int i = 3; i < n; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }

        // Print the Tribonacci series
        for (int i = 0; i < n; i++) {
            System.out.print(tribonacci[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
    }
}
