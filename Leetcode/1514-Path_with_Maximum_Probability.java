class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int dest) {
        double dist[] = new double[n];
        dist[src] = 1.0;
        for (int j = 0; j < n - 1; j++) {
            boolean change = false;
            int i = 0;
            for (int edge[] : edges) {
                int u = edge[0];
                int v = edge[1];
                double cost = succProb[i];
                i++;

                if (dist[v] < dist[u] * cost) {
                    dist[v] = dist[u] * cost;
                    change = true;
                }
                if (dist[u] < dist[v] * cost) {
                    dist[u] = dist[v] * cost;
                    change = true;
                }

            }
            if (!change)
                break;
        }

        return dist[dest];

    }
}