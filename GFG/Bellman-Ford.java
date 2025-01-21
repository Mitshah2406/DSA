// User function Template for Java

/*   Function to implement Bellman Ford
 *   edges: 2D array which represents the graph
 *   src: source vertex
 *   V: number of vertices
 */
class Solution {
    static int MOD = 100000000;
    static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] ans = new int[V];
        int m = edges.length;
        
        Arrays.fill(ans, MOD);
        ans[src] = 0;
        
        for(int i=0; i<V-1; i++){
            for(int j=0; j<m; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                
                if(ans[u] != MOD && ans[u] + w < ans[v]){
                    ans[v] = ans[u] + w;
                }
            }
        }
        
        boolean flag = false;
        for(int j=0; j<m; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            
            if(ans[u] != MOD && ans[u] + w < ans[v]){
                flag = true;
            }
        }
        
        if(flag){
            return new int[]{-1};
        }
        
        return ans;
    }
}