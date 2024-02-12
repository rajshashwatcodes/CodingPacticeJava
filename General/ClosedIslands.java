public class ClosedIslands {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int closedIslands = 0;

        // Iterate through the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is a land and is not visited
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j, rows, cols)) {
                        closedIslands++;
                    }
                }
            }
        }

        return closedIslands;
    }

    // Depth-First Search to check if island is closed
    private boolean dfs(int[][] grid, int i, int j, int rows, int cols) {
        // Base cases for out of bounds or water cell
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 1) {
            return false;
        }

        // Mark the cell as visited
        grid[i][j] = 1;

        // Recursive DFS in all four directions
        boolean up = dfs(grid, i - 1, j, rows, cols);
        boolean down = dfs(grid, i + 1, j, rows, cols);
        boolean left = dfs(grid, i, j - 1, rows, cols);
        boolean right = dfs(grid, i, j + 1, rows, cols);

        // If any of the adjacent cells is not closed, this island is not closed
        if (!up || !down || !left || !right) {
            return false;
        }

        // Island is closed
        return true;
    }

    public static void main(String[] args) {
        ClosedIslands islands = new ClosedIslands();
        int[][] grid = {
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
        };

        int closedIslands = islands.closedIsland(grid);
        System.out.println("Number of closed islands: " + closedIslands);
    }
}
