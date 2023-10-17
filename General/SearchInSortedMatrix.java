public class SearchInSortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Empty matrix.
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0; // Start from the first row.
        int col = cols - 1; // Start from the last column.

        while (row < rows && col >= 0) {
            int current = matrix[row][col];
            if (current == target) {
                return true; // Key found.
            } else if (current < target) {
                row++; // Move down in the matrix.
            } else {
                col--; // Move left in the matrix.
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
        
        int target = 6;
        boolean found = searchMatrix(matrix, target);
        
        if (found) {
            System.out.println("Key " + target + " is found in the matrix.");
        } else {
            System.out.println("Key " + target + " is not found in the matrix.");
        }
    }
}
