public class MinimumArrayJumps {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0; // No jumps needed if array has 0 or 1 element
        }

        int maxReach = arr[0]; // Maximum index that can be reached
        int steps = arr[0]; // Steps remaining at current index
        int jumps = 1; // Number of jumps

        for (int i = 1; i < n; i++) {
            // If current index is out of reach, a jump is needed
            if (i > maxReach) {
                return -1; // Not possible to reach end
            }

            // If all steps at current index are used up, take a jump
            if (steps == 0) {
                jumps++;

                // Update steps to the remaining steps of the new reach
                steps = maxReach - i;
            }

            // Update the maximum reach
            maxReach = Math.max(maxReach, i + arr[i]);

            // Reduce the remaining steps
            steps--;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int minJumps = minJumps(arr);
        if (minJumps == -1) {
            System.out.println("It is not possible to reach the end.");
        } else {
            System.out.println("Minimum number of jumps needed: " + minJumps);
        }
    }
}
