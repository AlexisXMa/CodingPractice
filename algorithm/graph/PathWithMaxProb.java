package algorithm.graph;

// 1514. Path with Maximum Probability

import java.util.*;

public class PathWithMaxProb {
    // Method: Dijkstra's Algorithm
    // Time = O(E + V log V)
    // Space = O(V + E)
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create the weighted undirected graph (adjacency list).
        // graph[a].get(b) := the prob of success from a to b
        Map<Integer, Double>[] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }

        // edges[i] = [a, b], a <-> b
        // prob(a <-> b) = succProb[i]
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            graph[a].put(b, prob);
            graph[b].put(a, prob);
        }

        // Initialize all probs of successes from start to end
        double[] probs = new double[n];
        // prob of success from start to start is 1
        probs[start] = 1.0;

        // Initialize a Priority Queue as a MaxHeap to return the highest prob so far
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Double.compare(probs[b], probs[a]));
        pq.offer(start);

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == end) {
                return probs[end];
            }
            for (int next: graph[cur].keySet()) {
                double edgeProb = graph[cur].get(next);
                if (probs[cur] * edgeProb > probs[next]) {
                    probs[next] = probs[cur] * edgeProb;
                    pq.offer(next);
                }
            }
        }
        return 0.0;
    }
}
