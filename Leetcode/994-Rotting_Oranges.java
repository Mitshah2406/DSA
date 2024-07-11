
// Medium
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.


//Link --> https://leetcode.com/problems/rotting-oranges/

class Pair{
    int i;int j; int t;
    public Pair(int i, int j, int t){
        this.i=i;
        this.j=j;
        this.t=t;
    }
}

class Solution {
    public int orangesRotting(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==2){
                    Pair p = new Pair(i,j,0);
                    q.add(p);
                }
            }
        }
        int minTime=0;
        while(q.size()>0){
            Pair rem = q.remove();

            int crow = rem.i;
            int ccol = rem.j;
            int ctime = rem.t;
            minTime=ctime;
            // i-1,j
            if(crow-1>=0 && mat[crow-1][ccol]==1){
                Pair p = new Pair(crow-1, ccol, ctime+1);
                q.add(p);
                mat[crow-1][ccol] = 2;
            }

            // i, j-1
             if(ccol-1>=0 && mat[crow][ccol-1]==1){
                Pair p = new Pair(crow, ccol-1, ctime+1);
                q.add(p);
                mat[crow][ccol-1] = 2;
            }
            // i+1, j
             if(crow+1<m && mat[crow+1][ccol]==1){
                Pair p = new Pair(crow+1, ccol, ctime+1);
                q.add(p);
                mat[crow+1][ccol] = 2;
            }
            // i, j+1
             if(ccol+1<n && mat[crow][ccol+1]==1){
                Pair p = new Pair(crow, ccol+1, ctime+1);
                q.add(p);
                mat[crow][ccol+1] = 2;
            }
        }

         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    return -1;
                }
            }
        }
        return minTime;
    }
}

// TC - O(n^2)
// SC - O(n)