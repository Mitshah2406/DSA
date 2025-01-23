class Pair{
    int i;
    int w;
    public Pair(int i, int w){
        this.i=i;
        this.w=w;
    }
}
class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Integer> q = new LinkedList();
        q.add(src);
        int n = adj.size();
        int vis[] = new int[n];
        Arrays.fill(vis, -1);
        vis[src] = 0;
        while(q.size()!=0){
            int rem = q.poll();
            for(int nbr : adj.get(rem)){
                if(vis[nbr]==-1){
                    vis[nbr] = vis[rem]+1;
                    q.add(nbr);
                }
            }
           
        }
        return vis;
    }
}
