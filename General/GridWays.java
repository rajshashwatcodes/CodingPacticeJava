public class GridWays {
    private int rows;
    private int columns;
    private int[][] grid;

    public GridWays(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
        initializeGrid();
    }

    private void initializeGrid() {
        // Initialize grid with values (for demonstration purposes)
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = value++;
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void moveUp(int steps) {
        System.out.println("Moving Up " + steps + " steps:");
        // Perform boundary checks and move up
        // Assuming (0,0) is the top-left corner
        for (int i = 0; i < steps; i++) {
            if (rows - steps >= 0) {
                rows -= 1;
                System.out.println("Current Position: (" + rows + ", " + columns + ")");
            } else {
                System.out.println("Cannot move further up.");
                break;
            }
        }
    }

    public void moveDown(int steps) {
        System.out.println("Moving Down " + steps + " steps:");
        // Perform boundary checks and move down
        // Assuming (0,0) is the top-left corner
        for (int i = 0; i < steps; i++) {
            if (rows + steps < grid.length) {
                rows += 1;
                System.out.println("Current Position: (" + rows + ", " + columns + ")");
            } else {
                System.out.println("Cannot move further down.");
                break;
            }
        }
    }

    public void moveLeft(int steps) {
        System.out.println("Moving Left " + steps + " steps:");
        // Perform boundary checks and move left
        // Assuming (0,0) is the top-left corner
        for (int i = 0; i < steps; i++) {
            if (columns - steps >= 0) {
                columns -= 1;
                System.out.println("Current Position: (" + rows + ", " + columns + ")");
            } else {
                System.out.println("Cannot move further left.");
                break;
            }
        }
    }

    public void moveRight(int steps) {
        System.out.println("Moving Right " + steps + " steps:");
        // Perform boundary checks and move right
        // Assuming (0,0) is the top-left corner
        for (int i = 0; i < steps; i++) {
            if (columns + steps < grid[0].length) {
                columns += 1;
                System.out.println("Current Position: (" + rows + ", " + columns + ")");
            } else {
                System.out.println("Cannot move further right.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        GridWays grid = new GridWays(rows, columns);

        System.out.println("Initial Grid:");
        grid.printGrid();

        grid.moveUp(2);
        grid.moveLeft(1);
        grid.moveRight(3);
        grid.moveDown(4);
    }
}
