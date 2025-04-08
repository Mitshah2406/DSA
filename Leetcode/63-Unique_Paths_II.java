class Solution {
    /*
    TC = O(m*n)
    SC = O(m*n)
    */
    public int find(int grid[][], int row, int col, int i, int j, int dp[][]) {
        if(i > row - 1 || j > col - 1 || grid[i][j] == 1){
            return 0;
        }
        if (i == row - 1 && j == col - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int bottom = find(grid, row, col, i + 1, j, dp);
        int right = find(grid, row, col, i, j + 1, dp);

        return dp[i][j] = bottom + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return find(obstacleGrid, m, n, 0, 0, dp);
    }
}