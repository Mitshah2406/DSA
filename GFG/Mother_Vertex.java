
class Solution {
    // public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int n, int i){
    //     vis[i] = 1;
    //     vis[n]++;
    //     for(int nbr: adj.get(i)){
    //         if(vis[nbr]==0){
    //             dfs(adj,vis,n, nbr);
    //         }
    //     }
    // }
    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        
        // sub optimal = use dfs starting from all nodes
        // for(int i=0;i<V;i++){
        //     int vis[] = new int[V+1];
        //     // Arrays.fill(vis,-1);
        //     dfs(adj, vis, V, i);
        //     // System.out.println("Size: "+vis[V]);
        //     if(vis[V]==V-1){
        //         return i;
        //     }
        // }
        
        // return -1;
        
        
        // optimal - do dfs using stack and add elements in stack when backtracking
        // the topmost will always be the mother vertex
        /*
        Time = O(V+E)
        Space = O(V) + O(V) = O(2V) = O(V)
        */
        Stack<Integer> st = new Stack();
        int vis[] = new int[V+1];
        Arrays.fill(vis,-1);
        for(int i=0;i<V;i++){
            if(vis[i]==-1){
                dfs(adj, vis, st, i, V);
            }
        }
        
        // verification step ... 
        // check stack top if it is the mother vertex.
        
        Arrays.fill(vis,-1);
        int top = st.peek();
        dfs(adj, vis, st, top, V);
        
        if(vis[V]==V-1){
            return top;
        }
        return -1;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,int vis[],Stack<Integer> st, int i, int n){
        vis[i] = 1;
        vis[n]++;
        
        for(int nbr: adj.get(i)){
            if(vis[nbr]==-1){
                dfs(adj, vis, st, nbr, n);
            }
        }
        
        st.push(i);
    }
}
