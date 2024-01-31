import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    public boolean isCyclic() {
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited.contains(i)) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCyclicUtil(int vertex, Set<Integer> visited, int parent) {
        visited.add(vertex);

        for (Integer neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                if (isCyclicUtil(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If the neighbor is already visited and not the parent, a back edge is found, indicating a cycle
                return true;
            }
        }

        return false;
    }
}

public class CycleDetection {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Adding edges to create a cycle
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        if (graph.isCyclic()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }
}
