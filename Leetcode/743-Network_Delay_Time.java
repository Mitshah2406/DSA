class Pair{
    int vtx;
    int time;

    public Pair(int v, int t){
        this.vtx = v;
        this.time = t;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ArrayList<ArrayList<Pair>> arr = new ArrayList();
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList());
        }

        for(int t[]: times){
            int u = t[0];
            int v = t[1];
            int ti = t[2];

            arr.get(u).add(new Pair(v,ti));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->Integer.compare(a.time,b.time));
        pq.add(new Pair(k, 0));
        int max = -1;
        while(pq.size()!=0){
            Pair rem = pq.poll();
            int vtx = rem.vtx;
            int time = rem.time;

            if(dist[vtx]!=Integer.MAX_VALUE){
                continue;
            }
            dist[vtx] = time;
            max = Math.max(max, time);
            for(Pair nbr : arr.get(vtx)){
                int nVtx = nbr.vtx;
                int nTime = nbr.time;

                if(dist[nVtx]!=Integer.MAX_VALUE){
                    continue;
                }
                pq.add(new Pair(nVtx, nTime+time));
            }
        }


        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
        }

        return max;
    }
}