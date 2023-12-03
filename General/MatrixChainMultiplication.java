public class MatrixChainMultiplication {

    // Recursive function to find the minimum number of multiplications
    private static int matrixChainOrder(int[] p, int i, int j) {
        if (i == j) {
            return 0;  // If there is only one matrix, no multiplication is needed
        }

        int minCost = Integer.MAX_VALUE;

        // Place parenthesis at different places between first and last matrix
        // and recursively calculate the minimum cost
        for (int k = i; k < j; k++) {
            int cost = matrixChainOrder(p, i, k) +
                       matrixChainOrder(p, k + 1, j) +
                       p[i - 1] * p[k] * p[j];

            if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] dimensions = {10, 20, 30, 40, 30};
        int n = dimensions.length;

        // The actual matrices are of dimensions: 10x20, 20x30, 30x40, 40x30

        int minMultiplications = matrixChainOrder(dimensions, 1, n - 1);

        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }
}
