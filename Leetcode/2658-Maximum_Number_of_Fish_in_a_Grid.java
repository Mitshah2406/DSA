class Solution {
    public boolean isInBounds(int i, int j, int n, int m) {
        return (i >= 0 && j >= 0 && i < n && j < m);
    }

    public int dfs(int grid[][], int i, int j, int dirs[][], int n, int m) {
        int ans = grid[i][j];
        grid[i][j] = 0;
        for (int d[] : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];

            if (isInBounds(nr, nc, n, m) && grid[nr][nc] > 0) {
                ans += dfs(grid, nr, nc, dirs, n, m);
            }
        }

        return ans;
    }

    public int findMaxFish(int[][] grid) {
        // idea - multi src dfs - return no of fishes collected. take max
        // small optimization according to question we dont need a vis arr, we. can directly amke the cell as 0

        // time = O(n*m)
        // space = (n*m){Recursion stack}
        int n = grid.length;
        int m = grid[0].length;

        int dirs[][] = {
                { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }
        };
        int maxFish = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    int res = dfs(grid, i, j, dirs, n, m);
                    maxFish = Math.max(maxFish, res);
                }
            }
        }
        return maxFish;
    }
}