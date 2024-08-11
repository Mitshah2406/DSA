class Solution {
    private boolean isInBounds(int newr, int newc, int n, int m){
        return (newc >= 0 && newc < m && newr >= 0 && newr < n);
    }
    private void dfs(char grid[][], int r, int c, int m, int n, boolean vis[][]) {
        int dirs[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < 4; i++) {
            int newr = r - dirs[i][0];
            int newc = c - dirs[i][1];

            if (isInBounds(newr, newc, n, m) && !vis[newr][newc] && grid[newr][newc]=='1') {
                vis[newr][newc] = true;
                dfs(grid, newr, newc, m, n, vis);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        boolean vis[][] = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j]=='1') {
                    vis[i][j] = true;
                    dfs(grid, i, j, m, n, vis);
                    ans++;
                }
            }
        }

        return ans;
    }
}