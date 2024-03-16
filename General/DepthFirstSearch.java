import java.util.*;

public class DepthFirstSearch {
    // Function to perform DFS traversal
    public static void dfs(int source, Map<Integer, List<Integer>> graph, boolean[] visited) {
        // Mark the current node as visited
        visited[source] = true;
        System.out.print(source + " ");

        // Recursively visit all adjacent vertices of the current vertex
        for (int neighbor : graph.getOrDefault(source, new ArrayList<>())) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 4, 5));
        graph.put(4, Arrays.asList(1, 2, 3, 5));
        graph.put(5, Arrays.asList(3, 4));

        // Number of vertices in the graph
        int vertices = 6;

        // Array to keep track of visited vertices
        boolean[] visited = new boolean[vertices];

        System.out.println("Depth First Traversal starting from vertex 0:");
        dfs(0, graph, visited);
    }
}
