import java.util.*;

class Graph {
    private int V;
    private List<List<Integer>> adj;
    private int time;
    private boolean[] visited;
    private int[] disc;
    private int[] low;
    private boolean[] ap;

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

    List<Integer> findArticulationPoints() {
        time = 0;
        visited = new boolean[V];
        disc = new int[V];
        low = new int[V];
        ap = new boolean[V];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                APUtil(i, -1, result);
        }

        return result;
    }

    void APUtil(int u, int parent, List<Integer> result) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                APUtil(v, u, result);
                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && low[v] >= disc[u])
                    ap[u] = true;

                if (parent == -1 && children > 1)
                    ap[u] = true;
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (ap[u])
            result.add(u);
    }
}

public class ArticulationPoint {
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        List<Integer> articulationPoints = g.findArticulationPoints();
        System.out.println("Articulation points in the graph:");
        for (int ap : articulationPoints) {
            System.out.println(ap);
        }
    }
}
