class Solution {
    /*
        Djisktra Algo with path counting
        Time Complexity => O(E log V)
        Space Complexity => O(V + E)
     */
    static int MOD = 1000000000 + 7;
    class Pair{
        int vtx;
        long cost;
        public Pair(int vtx, long cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
    public int countPaths(int n, int[][] roads) {
        // edges -> roads[][]

        // construction
        ArrayList<ArrayList<Pair>> adj = new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int road[]: roads){
            int u = road[0];
            int v = road[1];
            int cost = road[2];

            adj.get(u).add(new Pair(v,cost));
            adj.get(v).add(new Pair(u,cost));
        }
        long dist[] = new long[n];
        int ways[] = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair rem = pq.poll();
            int vtx = rem.vtx;
            long cost = rem.cost;
            if(dist[vtx]<cost){
                continue;
            }
            for(Pair nbr: adj.get(vtx)){
                int nVtx = nbr.vtx;
                long nCost = cost+nbr.cost;
                if(dist[nVtx]>nCost){
                    dist[nVtx] = nCost;
                    ways[nVtx] = ways[vtx]; 
                    pq.add(new Pair(nVtx, nCost));
                }else if(dist[nVtx]==nCost){
                    ways[nVtx] = ((ways[nVtx]%MOD)+(ways[vtx]%MOD)) %MOD;
                }
            }
        }
        return ways[n-1];
    }
}