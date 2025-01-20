class Solution {
    /*
     * Mutli Source BFS is needed as we need to check from all rotten oranges in all
     * 4 directions simultaneously how many time needed to rot
     * 
     * Time - O(n*m){Initial Src Finding} + O(m*n){BFS} = O(2(m*n)) ~ O(m*n)
     * Space - O(m*n){Queue Space} + O(m*n) {Visited Arr space} = O(2(m*n)) ~ O(m*n)
     */
    class Pair {
        int i;
        int j;
        int t;

        public Pair(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }

    public boolean isInBounds(int i, int j, int n, int m) {
        return (i >= 0 && j >= 0 && i < n && j < m);
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList();
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int dirs[][] = {
                { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
        };
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int time = 0;
        while (q.size() != 0) {
            Pair rem = q.poll();
            int r = rem.i;
            int c = rem.j;
            int t = rem.t;
            time = t;
            for (int i = 0; i < 4; i++) {
                int nR = r + dirs[i][0];
                int nC = c + dirs[i][1];
                if (isInBounds(nR, nC, n, m) && grid[nR][nC] == 1 && !vis[nR][nC]) {
                    vis[nR][nC] = true;
                    grid[nR][nC] = 2;
                    fresh--;
                    q.add(new Pair(nR, nC, t + 1));
                }
            }
        }
        if (fresh != 0) {
            return -1;
        }
        return time;
    }
}