class Solution {
    public int find(int i1, int j1, int i2, int n, int grid[][], int dp[][][]) {
        int j2 = i1 + j1 - i2;// i1+j1=i2+j2 => j2 = i1+j1-i2;
        if (i1 < 0 || j1 < 0 || i2 < 0 || j2 < 0 || grid[i1][j1] == -1
                || grid[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (i1 == 0 && i2 == 0 && j1 == 0 && j2 == 0) {
            return grid[i1][j1];
        }
        if (dp[i1][j1][i2] != -1) {
            return dp[i1][j1][i2];
        }
        int RR = find(i1, j1 - 1, i2, n, grid, dp);
        int DD = find(i1 - 1, j1, i2 - 1, n, grid, dp);
        int DR = find(i1 - 1, j1, i2, n, grid, dp);
        int RD = find(i1, j1 - 1, i2 - 1, n, grid, dp);
        int add = 0;
        if (i1 == i2 && j2 == j1) {
            add = grid[i1][j1];
        } else {
            add = grid[i1][j1] + grid[i2][j2];
        }
        return dp[i1][j1][i2] = Math.max(Math.max(RR, DD), Math.max(DR, RD)) + add;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        // both max path sum 
        // RR
        // DD
        // RD
        // DR
        // 4d -> 3d dp idealogy is both path can reach some point different than each other or converge at same point but will take same steps i.e 1
        /*
             0  1  2  3  4
         0 | 1, 0, 1, 0, 1 |
         1 | 0, 1, 0, 0, 1 |
         2 | 1, 1, 1, 0, 1 |
         3 | 1, 0, 1, 0, 1 |
         4 | 1, 0, 1, 0, 0 |
         */

        //  example i1,j1 = (0,3); i2,j2 = (3,0) [Both took 3 steps]
        // therefore (i1+j1)=(i2+j2), so here we can dynamic calculate j2 = i1+j1-i2;
        int dp[][][] = new int[n][n][n];
        for (int d1[][] : dp) {
            for (int d2[] : d1) {
                Arrays.fill(d2, -1);
            }
        }
        int ans = find(n - 1, n - 1, n - 1, n, grid, dp);
        if (ans < 0)
            return 0;
        return ans;

    }
}
