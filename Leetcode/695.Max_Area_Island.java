// Medium

// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

 

// Example 1:


// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.
// Example 2:

// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] is either 0 or 1.


// Link --> https://leetcode.com/problems/max-area-of-island/description/
class DisjointSet {
    public int[] rank, parent,  size;
    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];
        Arrays.fill(rank,0);
        Arrays.fill(size,1);
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
    }
    
    public int findUltimateParent(int node){
        if(node==parent[node]){
            return node;
        }
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }
    
    public void unionByRank(int u, int v){
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        
        if(pu==pv) return;
        
        if(rank[pu]< rank[pv]){
            parent[pu] = pv;
        }else if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }else{
             parent[pv] = pu;
             rank[pu]++;
        }
    }
    public void unionBySize(int u, int v){
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        
        if(pu==pv) return;
        
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] +=size[pu];

        }else{
            parent[pv] = pu;
             size[pu] +=size[pv];

        }
    }
} 

// row*m+col
class Solution {
    public static boolean isValid(int row, int col, int m, int n){
        return row >= 0 && row < m && col >= 0 && col < n;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet d = new DisjointSet(m*n+1);
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;

                int dr[] = {-1,1,0,0};
                int dc[] = {0,0,-1,1};

                for(int i=0;i<4;i++){
                    int nr = row + dr[i];
                    int nc = col + dc[i];

                    if(isValid(nr,nc,m,n) && grid[nr][nc]==1){

                        int currNodeNo = row*n+col; // 0*2+0 = 0
                        int discNodeNo = nr*n+nc; // 0*m+1 = 1


                        d.unionBySize(currNodeNo, discNodeNo);
                    }
                }
            }
        }

        int max = 0;

        //for all 1's find the size of its ultimate parent , return max size i.e the max island size
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1){
                    int up = d.findUltimateParent(row*n+col);
                    max = Math.max(max, d.size[up]);
                }
            }
        }
        
        return max;
    }
}


TC - O(n^2)
SC - O(mn)