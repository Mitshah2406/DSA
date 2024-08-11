class Solution {
    private boolean isInBounds(int newr, int newc, int n, int m){
        return (newc >= 0 && newc < m && newr >= 0 && newr < n);
    }

    private void dfs(int grid[][], boolean vis[][], int i, int j, int n, int m) {
        int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int k = 0; k < 4; k++) {
            int nr = i - dirs[k][0];
            int nc = j - dirs[k][1];
            if (isInBounds(nr, nc, n, m)==true && !vis[nr][nc] && grid[nr][nc] == 1) {
                vis[nr][nc] = true;
                dfs(grid, vis, nr, nc, n, m);
            }
        }
    }

    private int countIslands(int grid[][], boolean vis[][], int n, int m) {

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    vis[i][j] = true;
                    dfs(grid, vis, i, j, n, m);
                    ans++;
                }
            }
        }
        return ans;
    }

    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int islands = countIslands(grid, vis, n, m);
        if (islands != 1) {
            return 0;
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == false)
                    continue;
                grid[i][j] = 0;
                boolean nVisit[][] = new boolean[n][m];
                c = countIslands(grid, nVisit, n, m);
                if (c != 1) {
                    return 1;
                } 
                grid[i][j] = 1;
            }
        }

        return 2;
    }
}