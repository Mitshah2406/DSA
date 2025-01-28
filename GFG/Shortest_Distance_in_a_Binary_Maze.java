// User function Template for Java

class Solution {
    boolean isInBound(int i, int j, int n, int m){
        return (i>=0 && j>=0 && i<n && j<m);
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        
        if(grid[source[0]][source[1]]==0 || grid[destination[0]][destination[1]]==0){
            return -1;
        }
        
        
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{source[0], source[1]});
        for(int v[]:vis){
            Arrays.fill(v,-1);
        }
        vis[source[0]][source[1]] = 0;
        
        
        int dirs[][] = {
            {1,0},{0,1},{-1,0},{0,-1}
        };
        int level = 0;
        while(q.size()!=0){
            int[] rem = q.poll();
            
            
            for(int d[]: dirs){
                int r = rem[0]+d[0];
                int c = rem[1]+d[1];
                
                if(isInBound(r,c,n,m) && vis[r][c]==-1 && grid[r][c]==1){
                    q.add(new int[]{r,c});
                    vis[r][c] = vis[rem[0]][rem[1]]+1;
                }
            }
        }
        return vis[destination[0]][destination[1]];
    }
}
