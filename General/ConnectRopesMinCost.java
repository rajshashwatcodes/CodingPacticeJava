import java.util.PriorityQueue;

public class ConnectRopesMinCost {

    public static int connectRopes(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all ropes to the min heap
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Continue merging until only one rope remains
        while (minHeap.size() > 1) {
            // Extract the two smallest ropes
            int rope1 = minHeap.poll();
            int rope2 = minHeap.poll();

            // Calculate the cost of merging
            int mergeCost = rope1 + rope2;

            // Add the merge cost to the total cost
            totalCost += mergeCost;

            // Add the merged rope back to the min heap
            minHeap.add(mergeCost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        int minCost = connectRopes(ropes);
        System.out.println("Minimum cost to connect ropes: " + minCost);
    }
}
