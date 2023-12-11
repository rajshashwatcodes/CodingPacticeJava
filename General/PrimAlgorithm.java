import java.util.Arrays;

public class PrimAlgorithm {

    private static final int INF = Integer.MAX_VALUE;

    // Function to find the minimum spanning tree using Prim's algorithm
    private static void primMST(int graph[][]) {
        int vertices = graph.length;

        // Array to store the constructed MST
        int[] parent = new int[vertices];

        // Key values used to pick minimum weight edge in cut
        int[] key = new int[vertices];

        // Array to represent set of vertices included in MST
        boolean[] mstSet = new boolean[vertices];

        // Initialize all keys as INFINITE
        Arrays.fill(key, INF);

        // Always include the first vertex in MST
        key[0] = 0;
        parent[0] = -1;

        // Construct the MST
        for (int count = 0; count < vertices - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            // Update key value and parent index of the adjacent vertices
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph);
    }

    // A utility function to find the vertex with the minimum key value
    private static int minKey(int key[], boolean mstSet[]) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // A utility function to print the constructed MST stored in parent[]
    private static void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        primMST(graph);
    }
}
