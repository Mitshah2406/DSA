// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int ans[] = new int[V];
        Arrays.fill(ans, 100000000);
        ans[S] = 0;
        
        for(int i=0;i<V-1;i++){
            boolean isUpdated = false;
            for(ArrayList<Integer> edge: edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                
                if(ans[u]!=100000000 && ans[u]+w<ans[v]){
                    ans[v] = ans[u]+w;
                    isUpdated = true;
                }
            }
            if(!isUpdated) break;
        }
        
        for(ArrayList<Integer> edge: edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if(ans[u]!=100000000 && ans[u]+w<ans[v]){
                    return new int[]{-1};
                }
        }
            return ans;
    }
}
