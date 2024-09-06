//User function Template for Java


class Solution
{
    public void dfs(boolean vis[], int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean toPush){
        vis[i] = true;
        ArrayList<Integer> nbrs = adj.get(i);
        
        for(int j: nbrs){
            if(!vis[j]){
                dfs(vis,j,adj,st, toPush);
            }
        }
        
        if(toPush){
            st.push(i);
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(vis,i,adj,st, true);
            }
        }
        Arrays.fill(vis, false);
        int ans =0;
        ArrayList<ArrayList<Integer>> arr = new ArrayList();
        for(int i=0;i<V;i++){
            arr.add(new ArrayList());
        }
        
        for(int i=0;i<V;i++){
            ArrayList<Integer> nbrs = adj.get(i);
            
            for(int j: nbrs){
                arr.get(j).add(i);
            }
        }
        
        while(!st.isEmpty()){
            int rem = st.pop();

            if(!vis[rem]){
                ans++;
                dfs(vis, rem, arr,st, false);
            }
        }
        
        return ans;
    }
}
