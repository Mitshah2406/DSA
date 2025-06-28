class Pair {
    int vtx;
    int cost;
    int hops;

    public Pair(int vtx, int cost, int hops) {
        this.vtx = vtx;
        this.cost = cost;
        this.hops = hops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Construction
        ArrayList<ArrayList<Pair>> adj = new ArrayList();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int f[] : flights) {
            int u = f[0];
            int v = f[1];
            int cost = f[2];

            adj.get(u).add(new Pair(v, cost, 1));

        }
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(src, 0, 0));
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int vtx = rem.vtx;
            int cost = rem.cost;
            int hops = rem.hops;
            if (hops >  k+1)
                continue;
            if(dist[vtx]>cost){
                dist[vtx] = cost;
            }
            for (Pair nbr : adj.get(vtx)) {
                int nCost = cost + nbr.cost;
                int nHops = 1 + hops;
                if (nCost < dist[nbr.vtx]) {
                    q.add(new Pair(nbr.vtx, nCost, nHops));
                }
            }

        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}