import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
    }

    public boolean hasPath(int source, int destination) {
        boolean[] visited = new boolean[vertices];
        return hasPathDFS(source, destination, visited);
    }

    private boolean hasPathDFS(int current, int destination, boolean[] visited) {
        if (current == destination) {
            return true;
        }

        visited[current] = true;

        for (int neighbor : adjacencyList[current]) {
            if (!visited[neighbor]) {
                if (hasPathDFS(neighbor, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class HasPathDFS {
    public static void main(String[] args) {
        // Example usage:
        Graph graph = new Graph(6);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        int source = 0;
        int destination = 5;

        // Check if there is a path between source and destination
        boolean hasPath = graph.hasPath(source, destination);

        if (hasPath) {
            System.out.println("There is a path from " + source + " to " + destination);
        } else {
            System.out.println("There is no path from " + source + " to " + destination);
        }
    }
}
