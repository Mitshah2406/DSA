class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(src);
        
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        ans[src] = 0;
        boolean vis[] = new boolean[n];
        vis[src] = true;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(v).add(u);
            adj.get(u).add(v);
        }

        while(q.size()!=0){
           
            int rem = q.remove();
           
            ArrayList<Integer> nbrs = adj.get(rem);
            
            for(int i: nbrs){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                    ans[i] = ans[rem]+1;
                }
            }
        
        }
        
        return ans;
    }
}