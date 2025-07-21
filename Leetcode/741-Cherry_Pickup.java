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
        // int dp[][][] = new int[n][n][n];
        // for (int d1[][] : dp) {
        //     for (int d2[] : d1) {
        //         Arrays.fill(d2, -1);
        //     }
        // }
        // int ans = find(n - 1, n - 1, n - 1, n, grid, dp);
        // if (ans < 0)
        //     return 0;
        // return ans;

        // Tabulation 
        int dp[][][] = new int[n + 1][n + 1][n + 1];
        for (int d1[][] : dp) {
            for (int d2[] : d1) {
                Arrays.fill(d2, (int) -1e9);
            }
        }
        dp[0][0][0] = grid[0][0];

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    int j2 = i1 + j1 - i2;
                    if (j2 < 0 || j2 >= n)
                        continue;
                    if (grid[i1][j1] == -1 || grid[i2][j2] == -1)
                        continue;
                    int best = -1_000_000_000;

                    if (i1 > 0 && i2 > 0)
                        best = Math.max(best, dp[i1 - 1][j1][i2 - 1]); // DD
                    if (i1 > 0)
                        best = Math.max(best, dp[i1 - 1][j1][i2]); // DR
                    if (j1 > 0 && i2 > 0)
                        best = Math.max(best, dp[i1][j1 - 1][i2 - 1]); // RD
                    if (j1 > 0)
                        best = Math.max(best, dp[i1][j1 - 1][i2]); // RR

                    if (best == -1_000_000_000)
                        continue; // no valid previous path

                    int add = (i1 == i2 && j1 == j2) ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2];
                    dp[i1][j1][i2] = best + add;

                }
            }
        }

        int ans = dp[n - 1][n - 1][n - 1];
        return ans < 0 ? 0 : ans;

       
    }
}
