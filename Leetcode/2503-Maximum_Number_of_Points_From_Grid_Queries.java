class Pair implements Comparable<Pair> {
    int i;
    int j;
    int val;

    public Pair(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val=val;
    }

    @Override
    public int compareTo(Pair o) {
        return this.val - o.val;
    }
}

class Solution {
    public boolean isInBounds(int i, int j, int n, int m) {
        return (i < n && i >= 0 && j < m && j >= 0);
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;
        int q = queries.length;
        int sortedQ[][] = new int[q][2];
        for (int i = 0; i < q; i++) {
             sortedQ[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQ,  Comparator.comparingInt(a->a[0]));
        int ans[] = new int[q];
        int dirs[][] = {
                { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }
        };

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        boolean[][] vis = new boolean[n][m];

        pq.offer(new Pair(0, 0, grid[0][0]));
        vis[0][0] = true;
        int reachable = 0;
        for (int qu[] : sortedQ) {
            int val = qu[0];
            int idx = qu[1];
            while (!pq.isEmpty() && pq.peek().val < val) {
                Pair rem = pq.poll();
                int oldR = rem.i;
                int oldC = rem.j;
                reachable++;

                for (int d[] : dirs) {
                    int newR = oldR + d[0];
                    int newC = oldC + d[1];

                    if (isInBounds(newR, newC, n, m) && !vis[newR][newC]) {
                        pq.offer(new Pair(newR, newC, grid[newR][newC]));
                        vis[newR][newC] = true;
                    }
                }
            }
            ans[idx] = reachable;
        }

        return ans;
    }
}