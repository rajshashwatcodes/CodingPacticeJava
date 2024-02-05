import java.util.*;

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    public List<Integer> topologicalSort() {
        int[] inDegree = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // Calculate in-degrees for each vertex
        for (List<Integer> neighbors : adjList) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        // Enqueue vertices with in-degree 0
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            // Update in-degrees for neighbors
            for (int neighbor : adjList.get(current)) {
                inDegree[neighbor]--;

                // Enqueue vertices with in-degree 0
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check for a cycle (if the result size is less than vertices)
        if (result.size() != vertices) {
            throw new IllegalStateException("Graph has a cycle!");
        }

        return result;
    }
}

public class TopologicalSortBFS {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        // Adding edges to create a directed acyclic graph (DAG)
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> topologicalOrder = graph.topologicalSort();

        System.out.println("Topological Order:");
        for (int vertex : topologicalOrder) {
            System.out.print(vertex + " ");
        }
    }
}
