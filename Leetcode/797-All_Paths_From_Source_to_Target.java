class Solution {
    static ArrayList<Integer> ans;
    public void dfs(int[][] adj, int n, int src, int dest, List<List<Integer>> res){
        ans.add(src);
        if(src == dest){
            res.add(new ArrayList(ans));
        }
        
        for(int nbr: adj[src]){
            dfs(adj,n,nbr,dest,res);
        }
        ans.remove(ans.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ans = new ArrayList();

        // now do dfs without visited
        int src = 0;
        int dest = n-1;
        List<List<Integer>> res = new ArrayList();

        dfs(graph, n, src,dest, res);

        return res;
    }
    /*
    Time = O(V+E)
    Space= O(V)
    */
}