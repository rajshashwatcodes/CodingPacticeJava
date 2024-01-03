public class NQueens {

    public static void main(String[] args) {
        int n = 8; // Change this to the desired board size

        solveNQueens(n);
    }

    // Function to solve the N-Queens problem and print all solutions
    static void solveNQueens(int n) {
        int[] queensPlacement = new int[n];
        placeQueens(0, n, queensPlacement);
    }

    // Helper function to recursively place queens on the chessboard
    static void placeQueens(int row, int n, int[] queensPlacement) {
        if (row == n) {
            printSolution(queensPlacement);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queensPlacement)) {
                queensPlacement[row] = col;
                placeQueens(row + 1, n, queensPlacement);
            }
        }
    }

    // Helper function to check if placing a queen at a specific position is safe
    static boolean isSafe(int row, int col, int[] queensPlacement) {
        for (int i = 0; i < row; i++) {
            if (queensPlacement[i] == col || 
                queensPlacement[i] - i == col - row ||
                queensPlacement[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    // Helper function to print the chessboard with queens placed
    static void printSolution(int[] queensPlacement) {
        int n = queensPlacement.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((queensPlacement[i] == j) ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
