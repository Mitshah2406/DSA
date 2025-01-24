// User function Template for Java

class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int i, Stack<Integer> st, boolean toAdd){
        vis[i] = true;
        
        for(int nbr : adj.get(i)){
            if(!vis[nbr]){
                dfs(adj,vis,nbr,st,toAdd);
            }
        }
        
        if(toAdd){
         st.push(i);   
        }
    }

    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean vis[] = new boolean[n];
        Stack<Integer> st = new Stack();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj,vis,i,st,true);
            }
        }
        
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList();
        
        for(int i=0;i<n;i++){
            adj1.add(new ArrayList());
        }
        
        for(int i=0;i<n;i++){
            for(int nbr : adj.get(i)){
                adj1.get(nbr).add(i);
            }
        }
        
        boolean vis2[] = new boolean[n];
        int ans = 0;
        while(!st.isEmpty()){
            int rem = st.pop();
            
            if(!vis2[rem]){
                dfs(adj1, vis2, rem, st, false);
                ans++;
            }
        }
        return ans;
        
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

