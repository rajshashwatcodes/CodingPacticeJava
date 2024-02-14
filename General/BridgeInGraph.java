import java.util.*;

class Graph {
    private int V;
    private List<List<Integer>> adj;
    private int time;
    private List<int[]> bridges;

    Graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    List<int[]> findBridges() {
        time = 0;
        bridges = new ArrayList<>();
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                bridgeUtil(i, visited, disc, low, parent);
        }

        return bridges;
    }

    void bridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u])
                    bridges.add(new int[]{u, v});
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}

public class BridgeInGraph {
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        List<int[]> bridges = g.findBridges();
        System.out.println("Bridges in the graph:");
        for (int[] bridge : bridges) {
            System.out.println(bridge[0] + " - " + bridge[1]);
        }
    }
}
