import java.util.*;

class TarjanAlgorithm {

    private int V; // Number of vertices
    private List<List<Integer>> adjList; // Adjacency list
    private int time;
    private Stack<Integer> stack;
    private int[] disc; // Discovery time of vertices
    private int[] low; // Low value of vertices
    private boolean[] inStack; // To check if a vertex is in the stack
    private List<List<Integer>> stronglyConnectedComponents;

    public TarjanAlgorithm(int vertices) {
        this.V = vertices;
        this.adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        this.time = 0;
        this.stack = new Stack<>();
        this.disc = new int[V];
        this.low = new int[V];
        this.inStack = new boolean[V];
        this.stronglyConnectedComponents = new ArrayList<>();
    }

    // Function to add an edge to the graph
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Recursive function to find strongly connected components using Tarjan's algorithm
    private void tarjanSCC(int u) {
        disc[u] = time;
        low[u] = time;
        time++;
        stack.push(u);
        inStack[u] = true;

        for (int v : adjList.get(u)) {
            if (disc[v] == -1) {
                tarjanSCC(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            List<Integer> component = new ArrayList<>();
            int poppedVertex;
            do {
                poppedVertex = stack.pop();
                inStack[poppedVertex] = false;
                component.add(poppedVertex);
            } while (poppedVertex != u);

            stronglyConnectedComponents.add(component);
        }
    }

    // Function to find strongly connected components in the graph
    public List<List<Integer>> getStronglyConnectedComponents() {
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                tarjanSCC(i);
            }
        }
        return stronglyConnectedComponents;
    }

    public static void main(String[] args) {
        TarjanAlgorithm g = new TarjanAlgorithm(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        List<List<Integer>> stronglyConnectedComponents = g.getStronglyConnectedComponents();
        System.out.println("Strongly Connected Components:");
        for (List<Integer> component : stronglyConnectedComponents) {
            System.out.println(component);
        }
    }
}
