import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class to represent a graph using an adjacency list
class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    // Constructor to initialize the adjacency list
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        // Add destination to the adjacency list of source
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);

        // For an undirected graph, add source to the adjacency list of destination as well
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    // Method to print the adjacency list
    public void printAdjacencyList() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int vertex = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            System.out.print("Vertex " + vertex + " is connected to: ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyList {

    public static void main(String[] args) {
        // Create a graph
        Graph graph = new Graph();

        // Add edges to the graph
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        // Print the adjacency list
        System.out.println("Adjacency List:");
        graph.printAdjacencyList();
    }
}
