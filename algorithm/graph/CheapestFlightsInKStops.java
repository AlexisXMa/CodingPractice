package algorithm.graph;

// 787. Cheapest Flights Within K Stops

import java.util.*;

public class CheapestFlightsInKStops {
    // Method: Dijkstra's Algorithm
    // Time = O(E + V log V)
    // Method: Dijkstra's Algorithm
    // Time = O(E + V log V)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. Construct a adj matrix to represent the prices
        // prices[start][end] = price := the price from start to end
        int prices[][] = new int[n][n];
        for (int[] flight: flights) {
            prices[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances array
        int[] currentCosts = new int[n];
        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(currentCosts, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);

        currentCosts[src] = 0;
        currentStops[src] = 0;

        // The priority queue contains (node, cost, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] info = minHeap.poll();
            int node = info[0];
            int cost = info[1];
            int stops = info[2];

            // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }

            // If there are no more steps left, continue
            if (stops > k) {
                continue;
            }

            // Examine and relax all neighboring edges if possible
            for (int nei = 0; nei < n; nei++) {
                if (prices[node][nei] > 0) {
                    int edgePrice = prices[node][nei];
                    int newPrice = cost + edgePrice;
                    // Check if we have better price
                    if (newPrice < currentCosts[nei]) {
                        minHeap.offer(new int[]{nei, newPrice, stops + 1});
                        currentCosts[nei] = cost + edgePrice;
                    } else if (stops < currentStops[nei]) {
                        minHeap.offer(new int[]{nei, newPrice, stops + 1});
                    }
                    currentStops[nei] = stops;
                }
            }
        }

        return currentCosts[dst] == Integer.MAX_VALUE ? -1 : currentCosts[dst];
    }


    // Dijkstra's Algorithm - Implementation 2 (TLE)
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        // 1. Construct a map to represent the prices
        // map.get(start).get(end) = price := the price from start to end
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] flight: flights) {
            int start = flight[0];
            int end = flight[1];
            int price = flight[2];
            if (!prices.containsKey(start)) {
                prices.put(start, new HashMap<>());
            }
            prices.get(start).put(end, price);
        }

        // 2. Put <price, destination, available stops> in the Priority-Queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{ 0, src, k + 1 });
        while (!pq.isEmpty()) {
            int[] topCityInfo = pq.poll();
            int price = topCityInfo[0];
            int city = topCityInfo[1];
            int stop = topCityInfo[2];
            if (city == dst) {
                return price;
            }
            if (stop > 0) {
                Map<Integer, Integer> neighbors = prices.getOrDefault(city, new HashMap<>());
                for (int next: neighbors.keySet()) {
                    int newPrice = price + neighbors.get(next);
                    pq.offer(new int[]{ newPrice, next, stop - 1});
                }
            }
        }
        return -1;
    }
}
