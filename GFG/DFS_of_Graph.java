


class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int src, ArrayList<Integer> ans){
        ArrayList<Integer> nbrs = adj.get(src);
        
        for(int i=0;i<nbrs.size();i++){
            int v = nbrs.get(i);
            
            if(!vis[v]){
                vis[v] = true;
                ans.add(v);
                dfs(adj, vis, v, ans);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean vis[] = new boolean[V];
       ArrayList<Integer> ans = new ArrayList();
       
       for(int i=0;i<V;i++){
           if(!vis[i]){
               vis[i] = true;
               ans.add(i);
               dfs(adj, vis, i, ans);
           }
       }
       return ans;
    }
}