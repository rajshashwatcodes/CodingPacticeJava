import java.util.*;

class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int source, int target) {
        int vertices = graph.length;
        int[] distance = new int[vertices];
        Arrays.fill(distance, INF);

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        minHeap.add(new Node(source, 0));
        distance[source] = 0;

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            if (currentNode.vertex == target) {
                System.out.println("Shortest distance from " + source + " to " + target + ": " + currentNode.distance);
                return;
            }

            for (int neighbor = 0; neighbor < vertices; neighbor++) {
                if (graph[currentNode.vertex][neighbor] != 0) {
                    int newDist = currentNode.distance + graph[currentNode.vertex][neighbor];

                    if (newDist < distance[neighbor]) {
                        distance[neighbor] = newDist;
                        minHeap.add(new Node(neighbor, newDist));
                    }
                }
            }
        }

        System.out.println("No path found from " + source + " to " + target);
    }

    private static class Node {
        private int vertex;
        private int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 4, 0, 0, 0},
                {0, 0, 1, 7, 0, 0},
                {0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0}
        };

        int sourceNode = 0;
        int targetNode = 5;

        dijkstra(graph, sourceNode, targetNode);
    }
}
