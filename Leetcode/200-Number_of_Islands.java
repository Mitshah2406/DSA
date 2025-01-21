class Solution {
    public boolean isInBound(int i, int j, int n, int m) {
        return (i >= 0 && j >= 0 && i < n && j < m);
    }

    public void dfs(char grid[][], int i, int j, int n, int m, boolean vis[][], int dirs[][]) {
        vis[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nR = i + dirs[d][0];
            int nC = j + dirs[d][1];

            if (isInBound(nR, nC, n, m) && grid[nR][nC] == '1' && !vis[nR][nC]) {
                dfs(grid, nR, nC, n, m, vis, dirs);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

        int ans = 0;
        int dirs[][] = {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j, n, m, vis, dirs);
                    ans++;
                }
            }
        }
        return ans;
    }
}