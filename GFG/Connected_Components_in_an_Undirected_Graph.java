
class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[], int n, int i, ArrayList<Integer> t){
        vis[i] = true;
        t.add(i);
        
        for(int nbr: adj.get(i)){
            if(!vis[nbr]){
                dfs(adj,vis,n,nbr,t);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        /*
            Time = O(V+E)
            Space = O(V)
        */
        // construction
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList());
        }
        for(int e[] :edges){
            int u = e[0];
            int v= e[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[V];
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                ArrayList<Integer> t = new ArrayList();
                dfs(adj, vis, V , i, t);
                ans.add(t);
            }
        }
        
        return ans;
    }
}
