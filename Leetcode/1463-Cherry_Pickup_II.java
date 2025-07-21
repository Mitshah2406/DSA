class Solution {
    public int find(int i1, int j1, int j2, int n, int m, int grid[][], int dp[][][]) {
        int i2=i1;
        if (i1 >= n || j1 >= m || i2 >= n || j2 >= m || i1 < 0 || j1 < 0 || i2 < 0 || j2 < 0) {
            return Integer.MIN_VALUE;
        }
        if (i1 == n - 1 && i2 == n - 1) {
            if (j1 == j2) {
                return grid[i1][j1];
            } else {
                return grid[i1][j1] + grid[i2][j2];
            }
        }
        if(dp[i1][j1][j2]!=-1){
            return dp[i1][j1][j2];
        }
        // int dbr = find(i1 + 1, j1, i2 + 1, j2 + 1, n, m, grid);
        // int dbl = find(i1 + 1, j1, i2 + 1, j2 - 1, n, m, grid);
        // int bld = find(i1 + 1, j1 - 1, i2 + 1, j2, n, m, grid);
        // int brd = find(i1 + 1, j1 + 1, i2 + 1, j2, n, m, grid);
        // int brbl = find(i1 + 1, j1 + 1, i2 + 1, j2 - 1, n, m, grid);
        // int blbr = find(i1 + 1, j1 - 1, i2 + 1, j2 + 1, n, m, grid);
        // int dd = find(i1 + 1, j1, i2 + 1, j2, n, m, grid);
        // int brbr = find(i1 + 1, j1 + 1, i2 + 1, j2 + 1, n, m, grid);
        // int blbl = find(i1 + 1, j1 - 1, i2 + 1, j2 - 1, n, m, grid);
        int max = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                max = Math.max(max, find(i1 + 1, j1 + dj1, j2 + dj2, n, m, grid,dp));
            }
        }
        int contri = 0;
        if (i1 == i2 && j1 == j2) {
            contri = grid[i1][j1];
        } else {
            contri = grid[i1][j1] + grid[i2][j2];
        }
        return dp[i1][j1][j2] = max + contri;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for(int dp1[][]: dp){
            for(int dp2[]: dp1){
                    Arrays.fill(dp2,-1);
            }
        }
        int ans = find(0, 0, m - 1, n, m, grid, dp);
        return ans < 0 ? 0 : ans;
    }
}

// Down, Bottom Left, Bottom Right

// D, BR
// D, BL
// BL, D
// BR, D
// BR, BL
// BL, BR
// D,D
//BR,BR
//BL,Bl