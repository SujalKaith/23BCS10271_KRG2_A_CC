import java.util.*;

class Dijkstra {
    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int wt = neighbor.dist;

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }
}
