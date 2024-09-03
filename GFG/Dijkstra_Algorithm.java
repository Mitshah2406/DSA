//User function Template for Java

class Pair implements Comparable<Pair>{
    int v;
    int wt;
    public Pair(int v, int w){
        this.v= v;
        this.wt = w;
    }
    public int compareTo(Pair n){
        return this.wt - n.wt;
    }
}
class Solution
{
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
       
       for(int i=0;i<V;i++){
           graph.add(new ArrayList());
       }
       int i = 0;
       for(ArrayList<ArrayList<Integer>> edges : adj){
           for(ArrayList<Integer> edge: edges){
               graph.get(i).add(new Pair(edge.get(0), edge.get(1)));
           }
           i++;
       }
       
       
       PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
       pq.add(new Pair(S, 0));
       int dist[] = new int[V];
       Arrays.fill(dist, Integer.MAX_VALUE);
       
       while(pq.size()>0){
           Pair rem = pq.remove();
           
           ArrayList<Pair> nbrs = graph.get(rem.v);
           
           if(dist[rem.v]!=Integer.MAX_VALUE) continue;
           
           dist[rem.v] = rem.wt;
           for(Pair p:nbrs){
               if(dist[p.v]!=Integer.MAX_VALUE) continue;
               
               pq.add(new Pair(p.v, rem.wt+p.wt));
           }
       }
       
       return dist;
    }
}

