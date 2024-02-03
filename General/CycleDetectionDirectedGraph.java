import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DirectedGraph {
    private int vertices;
    private List<List<Integer>> adjList;

    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && hasCycleUtil(i, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycleUtil(int v, boolean[] visited, boolean[] recStack) {
        visited[v] = true;
        recStack[v] = true;

        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true; // Cycle detected (back edge to a node in the current recursion stack)
            }
        }

        recStack[v] = false; // Remove the vertex from the current recursion stack
        return false;
    }
}

public class CycleDetectionDirectedGraph {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(4);

        // Adding edges to create a directed graph with a cycle
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        if (graph.hasCycle()) {
            System.out.println("The directed graph contains a cycle.");
        } else {
            System.out.println("The directed graph does not contain a cycle.");
        }
    }
}
