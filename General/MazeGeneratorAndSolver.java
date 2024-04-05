import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class MazeGeneratorAndSolver {
    private static final int SIZE = 10;
    private static final char WALL = '#';
    private static final char PATH = ' ';
    private static final char VISITED = '.';
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static char[][] maze = new char[SIZE][SIZE];

    public static void main(String[] args) {
        generateMaze();
        printMaze();
        System.out.println("Solving the maze...");
        boolean solved = solveMaze(0, 0);
        if (solved) {
            System.out.println("Maze solved!");
        } else {
            System.out.println("No solution found.");
        }
        printMaze();
    }

    private static void generateMaze() {
        Random random = new Random();
        for (char[] row : maze) {
            Arrays.fill(row, WALL);
        }
        for (int i = 1; i < SIZE; i += 2) {
            for (int j = 1; j < SIZE; j += 2) {
                maze[i][j] = PATH;
            }
        }
        for (int i = 1; i < SIZE; i += 2) {
            for (int j = 1; j < SIZE; j += 2) {
                int direction = random.nextInt(4);
                int[] d = DIRECTIONS[direction];
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni >= 0 && ni < SIZE && nj >= 0 && nj < SIZE) {
                    maze[ni][nj] = PATH;
                }
            }
        }
        maze[0][0] = PATH;
        maze[SIZE - 1][SIZE - 1] = PATH;
    }

    private static boolean solveMaze(int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            row = current[0];
            col = current[1];
            if (maze[row][col] == VISITED) {
                continue;
            }
            maze[row][col] = VISITED;
            if (row == SIZE - 1 && col == SIZE - 1) {
                return true;
            }
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isValid(newRow, newCol)) {
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
        return false;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && (maze[row][col] == PATH || maze[row][col] == VISITED);
    }

    private static void printMaze() {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
