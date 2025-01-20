class Solution {
    // single source dfs
    // Time Complexity: O(V+E)
    // Space Complexity: O(V)
    public static void dfs(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> adj,boolean vis[], int src){
        vis[src] = true;
        arr.add(src);
        ArrayList<Integer> nbrs = adj.get(src);
        
        for(int nbr : nbrs){
            if(!vis[nbr]){
                dfs(arr, adj, vis, nbr);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> arr = new ArrayList();
        int V = adj.size();
        boolean vis[] = new boolean[V];
        dfs(arr, adj, vis, 0);
        return arr;
    }
}