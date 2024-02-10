public class FloodFill {
    // Function to perform flood fill
    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];
        
        // Base cases for recursion
        if (oldColor == newColor) return;
        if (sr < 0 || sr >= rows || sc < 0 || sc >= cols) return;
        if (image[sr][sc] != oldColor) return;
        
        // Fill current pixel with new color
        image[sr][sc] = newColor;
        
        // Recursively fill surrounding pixels
        floodFill(image, sr + 1, sc, newColor); // Down
        floodFill(image, sr - 1, sc, newColor); // Up
        floodFill(image, sr, sc + 1, newColor); // Right
        floodFill(image, sr, sc - 1, newColor); // Left
    }
    
    // Utility function to print image matrix
    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        
        System.out.println("Original Image:");
        printImage(image);
        
        floodFill(image, sr, sc, newColor);
        
        System.out.println("\nImage after Flood Fill:");
        printImage(image);
    }
}
