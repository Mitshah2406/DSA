class Solution {
    public boolean isInBound(int i, int j, int n, int m) {
        return (i >= 0 && j >= 0 && i < n && j < m);
    }

    public void dfs(char grid[][], int i, int j, int n, int m, int dirs[][]) {
        grid[i][j] = '0';
    
        for (int d = 0; d < 4; d++) {
            int nR = i + dirs[d][0];
            int nC = j + dirs[d][1];

            if (isInBound(nR, nC, n, m) && grid[nR][nC] == '1') {
                dfs(grid, nR, nC, n, m, dirs);
            }
        }
    }
    // TC - O(n*m)
    // SC - O(1)
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // generally better to use a vis array although compromising space
        int ans = 0;
        int dirs[][] = {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, m, dirs);
                    ans++;
                }
            }
        }
        return ans;
    }
}