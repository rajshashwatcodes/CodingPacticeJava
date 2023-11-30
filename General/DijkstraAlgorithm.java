import java.util.*;

class Graph {
    private int vertices;
    private List<List<Node>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Node(destination, weight));
        adjList.get(destination).add(new Node(source, weight));
    }

    public void dijkstra(int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));
        distance[source] = 0;

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            for (Node neighbor : adjList.get(currentNode.vertex)) {
                int newDist = distance[currentNode.vertex] + neighbor.weight;

                if (newDist < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDist;
                    minHeap.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        // Print the shortest distances
        for (int i = 0; i < vertices; i++) {
            System.out.println("Shortest distance from source to vertex " + i + ": " + distance[i]);
        }
    }

    private static class Node {
        private int vertex;
        private int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 5);

        int sourceNode = 0;
        graph.dijkstra(sourceNode);
    }
}
