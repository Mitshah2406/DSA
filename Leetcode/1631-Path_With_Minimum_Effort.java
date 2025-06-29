class Pair {
    int diff;
    int i;
    int j;

    public Pair(int diff, int i, int j) {
        this.diff = diff;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    /*
        Modified Dijkstra Algo on Grid
        Time = O(ElogV) where E = nm, V = nm; == O(nm*log(nm))
        Space = O(nm) [dist arr]
     */
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.diff, b.diff));
        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];
        for (int d[] : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        int dirs[][] = {
                { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }
        };
        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair rem = pq.poll();
            int diff = rem.diff;
            int i = rem.i;
            int j = rem.j;
            if (diff > dist[i][j]) continue;
            for (int d = 0; d < 4; d++) {
                int nr = i + dirs[d][0];
                int nc = j + dirs[d][1];
                if (isInBound(nr, nc, n, m) && dist[nr][nc] > diff) {
                    int nDiff = Math.abs(heights[i][j] - heights[nr][nc]);
                    dist[nr][nc] = Math.max(diff, nDiff);
                    pq.add(new Pair(dist[nr][nc], nr, nc));
                }
            }
        }

        return dist[n-1][m-1];
    }
    public boolean isInBound(int r, int c, int n, int m){
        return (r>=0 && c>=0 && r<n && c<m);
    }
}