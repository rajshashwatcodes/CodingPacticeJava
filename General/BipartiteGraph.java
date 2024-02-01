import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BipartiteGraph {
    private int V;
    private ArrayList<ArrayList<Integer>> adjList;

    public BipartiteGraph(int vertices) {
        this.V = vertices;
        this.adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    public boolean isBipartite() {
        int[] colors = new int[V];
        for (int i = 0; i < V; i++) {
            colors[i] = -1; // Initialize colors as -1 (unassigned)
        }

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1 && !isBipartiteUtil(i, colors)) {
                return false;
            }
        }

        return true;
    }

    private boolean isBipartiteUtil(int src, int[] colors) {
        colors[src] = 1; // Color the source vertex

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adjList.get(u)) {
                if (colors[v] == -1) {
                    colors[v] = 1 - colors[u]; // Assign opposite color to the adjacent vertex
                    queue.add(v);
                } else if (colors[v] == colors[u]) {
                    return false; // If adjacent vertices have the same color, the graph is not bipartite
                }
            }
        }

        return true;
    }
}

public class BipartiteGraph {
    public static void main(String[] args) {
        BipartiteGraph graph = new BipartiteGraph(4);

        // Adding edges to create a bipartite graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
