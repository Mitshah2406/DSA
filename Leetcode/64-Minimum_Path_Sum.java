class Solution {
    public int minPath(int i, int j, int grid[][], int dp[][]) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return (int) 1e9;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int left = minPath(i, j - 1, grid, dp) + grid[i][j];
        int up = minPath(i - 1, j, grid, dp) + grid[i][j];

        return dp[i][j] = Math.min(left, up);
    }

    public int minPathSum(int[][] grid) {
        // int rows = grid.length;
        // int cols = grid[0].length;
        // int dp[][] = new int[rows][cols];
        // for (int d[] : dp)
        //     Arrays.fill(d, -1);
        // return minPath(rows - 1, cols - 1, grid, dp);

        // ==> TABULATION

        // int rows = grid.length;
        // int cols = grid[0].length;
        // int dp[][] = new int[rows][cols];

        // // base case
        // dp[0][0] = grid[0][0];
        // int neg = (int) 1e9;

        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         if (i == 0 && j == 0)
        //             continue;

        //         int left = j - 1 < 0 ? neg : dp[i][j - 1];
        //         int up = i - 1 < 0 ? neg : dp[i - 1][j];

        //         dp[i][j] = Math.min(left, up) + grid[i][j];
        //     }
        // }

        // return dp[rows - 1][cols - 1];

        // ==> TABULATION

        int rows = grid.length;
        int cols = grid[0].length;
        int prev[] = new int[cols];

        // base case
        // prev[0] = grid[0][0];
        int neg = (int) 1e9;

        for (int i = 0; i < rows; i++) {
            int curr[] = new int[cols];
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int left = j - 1 < 0 ? neg : curr[j - 1];
                    int up = i - 1 < 0 ? neg : prev[j];

                    curr[j] = Math.min(left, up) + grid[i][j];
                }
            }
            prev = curr;
        }

        return prev[cols - 1];
    }
}