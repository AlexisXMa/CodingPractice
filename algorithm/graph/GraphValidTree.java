package algorithm.graph;

// 261. Graph Valid Tree

import java.util.*;

public class GraphValidTree {
    // Method: DFS
    // Time = O(n); Space = O(n)
    public boolean validTree(int n, int[][] edges) {
        // Initialize an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();

        // Initialize vertices
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        // Add edges
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        boolean[] visited = new boolean[n];

        // Check if there is any cycle
        if (hasCycle(graph, visited, 0, -1)) {
            return false;
        }

        // Check if all nodes are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    // Check if the undirected graph has cycle started from node u
    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, int u, int parent) {
        visited[u] = true;

        for (int i = 0; i < graph.get(u).size(); i++) {
            int v = graph.get(u).get(i);
            if ((visited[v] && parent != v)
                    || (!visited[v] && hasCycle(graph, visited, v, u))) {
                return true;
            }
        }

        return false;
    }


    // Method: Union Find
    // Time = O(n * prop(n))
    // Space = O(n)
    public boolean validTree2(int n, int[][] edges) {
        // Initialize n isolated nodes
        int[] nodes = new int[n];
        Arrays.fill(nodes, -1);

        // Perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nodes, edges[i][0]);
            int y = find(nodes, edges[i][1]);

            // If two nodes are in the same set, then
            // there is a cycle
            if (x == y) {
                return false;
            }

            // union
            nodes[x] = y;
        }

        return edges.length == n - 1;
    }

    private int find(int[] nodes, int n) {
        if (nodes[n] == -1) {
            return n;
        }
        return find(nodes, nodes[n]);
    }
}
