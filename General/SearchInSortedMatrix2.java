public class SearchInSortedMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Empty matrix.
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = rows - 1; // Start from the last row.
        int col = 0; // Start from the first column.

        while (row >= 0 && col < cols) {
            int current = matrix[row][col];
            if (current == target) {
                return true; // Key found.
            } else if (current < target) {
                col++; // Move right in the matrix.
            } else {
                row--; // Move up in the matrix.
            }
        }

        return false; // Key not found.
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int target = 9;
        boolean found = searchMatrix(matrix, target);

        if (found) {
            System.out.println("Key " + target + " is found in the matrix.");
        } else {
            System.out.println("Key " + target + " is not found in the matrix.");
        }
    }
}
