import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    public List<List<Integer>> findConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> connectedComponents = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> connectedComponent = new ArrayList<>();
                dfs(i, visited, connectedComponent);
                connectedComponents.add(connectedComponent);
            }
        }

        return connectedComponents;
    }

    private void dfs(int v, boolean[] visited, List<Integer> connectedComponent) {
        visited[v] = true;
        connectedComponent.add(v);

        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, connectedComponent);
            }
        }
    }
}

public class ConnectedComponentsCode {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        // Adding edges to create connected components
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        List<List<Integer>> connectedComponents = graph.findConnectedComponents();

        System.out.println("Connected Components:");
        for (List<Integer> component : connectedComponents) {
            System.out.println(component);
        }
    }
}
