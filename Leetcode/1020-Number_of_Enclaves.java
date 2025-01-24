class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
/*
Time - O(n*m);
Space - O(n*m)
*/
class Solution {
    public boolean isInBound(int r,int c,int n, int m){
        return (
            r>=0 && c>=0 && r<n && c<m
        );
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList();
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                q.add(new Pair(0, j));
                vis[0][j] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                q.add(new Pair(i, m - 1));
                vis[i][m - 1] = true;
            }
        }
        for (int j = m - 1; j >= 0; j--) {
            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                q.add(new Pair(n - 1, j));
                vis[n - 1][j] = true;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                q.add(new Pair(i, 0));
                vis[i][0] = true;
            }
        }
        int dirs[][] = {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int r = rem.i;
            int c = rem.j;
            grid[r][c] = 0;
            for (int i = 0; i < 4; i++) {
                int nR = r + dirs[i][0];
                int nC = c + dirs[i][1];

                if (isInBound(nR, nC, n, m) && grid[nR][nC] == 1 && !vis[nR][nC]) {
                    vis[nR][nC] = true;
                    q.add(new Pair(nR, nC));
                }
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans+=grid[i][j];
            }
        }
        return ans;
    }
}

