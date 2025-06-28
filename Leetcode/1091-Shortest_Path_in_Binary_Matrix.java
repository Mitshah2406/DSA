class Solution {
    /*
        Simple BFS 8 directional solution, just take 3 size arr[] as {i,j,node_count}
        then do simple bfs, and when u get cornermost node, just take that node_count as ans.

        Time = O(n*n) * O(8) 
        Space = O(n^2) nodes
     */
    public boolean isInBound(int i, int j, int n){
        return (
            i>=0 && j>=0 && i<n && j<n
        );
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int dirs[][] = {
            {1,0}, {-1,0}, {0,1}, {0,-1}, {-1,-1}, {-1,1}, {1,-1},{1,1}
        };

        Queue<int[]> q = new LinkedList();
        if(grid[0][0]!=0){
            return -1;
        }

        q.add(new int[]{0,0,1});
        grid[0][0]=1;
        int ans = -1;
        while(!q.isEmpty()){
            int rem[] = q.poll();
            if(rem[0]==n-1 && rem[1]==n-1){
                ans = rem[2];
            }
            for(int i=0;i<8;i++){
                int nr = rem[0] + dirs[i][0];
                int nc = rem[1] + dirs[i][1];

                if(isInBound(nr,nc,n) && grid[nr][nc]==0){
                    q.add(new int[]{nr,nc, rem[2]+1});
                    grid[nr][nc]=1;
                }
            }
        }

        return ans;
    }
}

