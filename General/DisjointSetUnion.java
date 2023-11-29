import java.util.*;

class DisjointSetUnion {
    private int[] parent;
    private int[] rank;

    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];

        // Initialize each element as a separate set
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the representative (root) of the set to which x belongs
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union of two sets (by rank to keep the tree balanced)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // Number of elements
        DisjointSetUnion dsu = new DisjointSetUnion(n);

        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(1, 4);

        System.out.println("Are 0 and 3 in the same set? " + (dsu.find(0) == dsu.find(3)));
        System.out.println("Are 1 and 2 in the same set? " + (dsu.find(1) == dsu.find(2)));
    }
}
