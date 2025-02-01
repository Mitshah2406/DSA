class DisjointSet {
    int par[];
    int rank[];
    int size[];
    int len;
    int indexing = 0;

    public DisjointSet(int n) {
        this.len = n;
        par = new int[n];
        size = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }
    }

    public boolean unionByRank(int a, int b) {
        int parX = find(a);
        int parY = find(b);
        if (parX == parY)
            return false;

        if (rank[parX] > rank[parY]) {
            par[parY] = parX;
        } else if (rank[parY] > rank[parX]) {
            par[parX] = parY;
        } else {
            par[parX] = parY;
            rank[parY]++;
        }
        return true;
    }

    public boolean unionBySize(int a, int b) {
        int parX = find(a);
        int parY = find(b);
        if (parX == parY)
            return false;

        if (size[parX] > size[parY]) {
            par[parY] = parX;
            size[parX] += size[parY];
        } else {
            par[parX] = parY;
            size[parY] += size[parX];
        }
        return true;
    }

    public int find(int x) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x]);
    }

}

class Solution {
    public int cnv(int row, int totalCol, int col) {
        return (row * totalCol + col);
    }

    public boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && j >= 0 && i < n && j < m);
    }

    public int maxAreaOfIsland(int[][] grid) {
        // DSU approach - time - O(nm) {amortized}
        // DSU approach - space - O(nm)
        // int n = grid.length;
        // int m = grid[0].length;
        // DisjointSet dsu = new DisjointSet(n*m);
        // int dirs[][] = {
        // {1,0},{0,1},{-1,0},{0,-1}
        // };
        // int max = 0;
        // for(int i=0;i<n;i++){
        // for(int j=0;j<m;j++){
        // int curr = grid[i][j];
        // int conv = cnv(i,m,j);

        // if(curr==1){
        // max = Math.max(1,max);
        // for(int d[]: dirs){
        // int nr = i + d[0];
        // int nc = j + d[1];
        // int nConv = cnv(nr,m,nc);
        // if(isValid(nr,nc,m,n) && grid[nr][nc]==1){
        // boolean res = dsu.unionBySize(conv, nConv);

        // if(res){
        // int uPar = dsu.find(nConv);
        // int size = dsu.size[uPar];
        // max = Math.max(size, max);
        // }
        // }
        // }
        // }
        // }
        // }
        // return max;

        // Simple DFS
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int dirs[][] = {
                { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    int ans = dfs(grid, vis, i, j, n, m, dirs);
                    res = Math.max(res, ans);
                }
            }
        }

        return res;
    }

    public int dfs(int grid[][], boolean vis[][], int i, int j, int n, int m, int dirs[][]) {
        vis[i][j] = true;

        int noOfLands = 0;
        noOfLands++;
        for (int d[] : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];

            if (isValid(nr, nc, m, n) && !vis[nr][nc] && grid[nr][nc] == 1) {
                noOfLands += dfs(grid, vis, nr, nc, n, m, dirs);
            }
        }

        return noOfLands;
    }
}