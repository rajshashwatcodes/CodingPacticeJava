import java.util.*;

public class BreadthFirstSearch {
    // Function to perform BFS traversal
    public static void bfs(int source, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        // Mark the source node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, mark it as visited and enqueue it
            for (int neighbor : graph.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 4, 5));
        graph.put(4, Arrays.asList(1, 2, 3, 5));
        graph.put(5, Arrays.asList(3, 4));

        // Number of vertices in the graph
        int vertices = 6;

        System.out.println("Breadth First Traversal starting from vertex 0:");
        bfs(0, graph);
    }
}
