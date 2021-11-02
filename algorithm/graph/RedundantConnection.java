package algorithm.graph;

// 684. Redundant Connection

public class RedundantConnection {
    // Method: Union Set
    // Time = O(n)
    // Space = O(n) for parent array and recursion stack
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] e: edges) {
            if (find(parent, e[0]) == find(parent, e[1])) {
                return e;
            } else {
                union(parent, e[0], e[1]);
            }
        }
        return edges[0];
    }

    private int find(int[] parent, int n) {
        if (n != parent[n]) {
            parent[n] = find(parent, parent[n]);
        }
        return parent[n];
    }

    private void union(int[] parent, int n1, int n2) {
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);
        parent[p1] = p2;
    }
}
