class Solution {
    /*
    TC => O(2) {cost of one fn} X No of recursive Calls {m*n} = O(m*n)
    SC => O(m*n) {Space}
    */
    public int calc(int grid[][], int n, int m, int i, int j, int dp[][]) {
        if (i >= n || j >= m)
            return Integer.MAX_VALUE;

        if (i == n - 1 && j == m - 1)
            return grid[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = calc(grid, n, m, i + 1, j, dp);
        int right = calc(grid, n, m, i, j + 1, dp);

        int ans = Math.min(down, right);

        if (ans != Integer.MAX_VALUE) {
            ans += grid[i][j];
        }
        return dp[i][j] = ans;
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n + 1][m + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return calc(grid, n, m, 0, 0, dp);
    }
}