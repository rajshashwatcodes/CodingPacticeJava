import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    Graph getTranspose() {
        Graph g = new Graph(V);
        for (int v = 0; v < V; v++) {
            for (Integer n : adj[v]) {
                g.adj[n].add(v);
            }
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (Integer n : adj[v]) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        Graph gr = getTranspose();

        for (int i = 0; i < V; i++)
            visited[i] = false;

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited[v]) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }
}

public class KosarajuAlgorithm {
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Strongly connected components are:");
        g.printSCCs();
    }
}
