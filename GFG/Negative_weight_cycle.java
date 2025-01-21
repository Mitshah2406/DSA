//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int dist[] = new int[n];
        for(int src=0;src<n;src++){
            Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        
            for(int i=0;i<n-1;i++){
            for(int e[]: edges){
                int u = e[0];
                int v = e[1];
                int c = e[2];
                
                if(dist[u]!=Integer.MAX_VALUE &&
                dist[u]+c<dist[v]
                ){
                    dist[v] = dist[u]+c;
                }
            }
                }
        
        
        
            for(int e[]: edges){
                int u = e[0];
                int v = e[1];
                int c = e[2];
                
                if(dist[u]!=Integer.MAX_VALUE &&
                dist[u]+c<dist[v]
                ){
                    dist[v] = dist[u]+c;
                    return 1;
                }
            }
            
        }
        return 0;
    }
}