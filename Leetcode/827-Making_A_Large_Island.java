class DisjointSet {
    int n;
    int size[];
    int parent[];

    public DisjointSet(int n) {
        this.n = n;
        this.size = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.size[i] = 1;
            this.parent[i] = i;
        }
    }

    public int find(int x) {
        // Path Compression -> O(ackerman(N)) amortized time
        if (x == parent[x]) return x;
        int t = find(parent[x]);
        return parent[x] = t;
    }

    public boolean union(int x, int y) {
        int ux = find(x);
        int uy = find(y);

        if (ux == uy) {
            return false;
        }
        // Union by Size
        if (size[ux] > size[uy]) {
            parent[uy] = ux;
            size[ux] += size[uy];
        } else {
            parent[ux] = uy;
            size[uy] += size[ux];
        }
        return true;
    }
}

class Solution {
    public boolean isInBound(int i, int j, int n) {
        return (i >= 0 && j >= 0 && i < n && j < n);
    }

    public int convertTo1D(int r, int c, int m) {
        return (r * m) + c;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int totalCells = n * n;
        DisjointSet ds = new DisjointSet(totalCells);
        int dirs[][] = {
            {1, 0}, {0, 1}, {0, -1}, {-1, 0}
        };

        // Step 1: Form components
        // Complexity:
        // Outer loop visits every cell once -> O(n^2)
        // Each union/find takes O(ackerman(N)) amortized
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int nodeNo = convertTo1D(i, j, n);

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dirs[d][0];
                        int nc = j + dirs[d][1];

                        if (isInBound(nr, nc, n) && grid[nr][nc] == 1) {
                            int adjNodeNo = convertTo1D(nr, nc, n);
                            ds.union(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
        }

        // Step 2: Check each 0-cell
        // For every zero cell, we look at up to 4 neighbors, do find() calls (O(ackerman(N))),
        // and sum sizes. HashSet takes O(1) amortized for add/lookup.
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nodeNo = convertTo1D(i, j, n);
                if (grid[i][j] == 0) {
                    HashSet<Integer> hs = new HashSet();
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dirs[d][0];
                        int nc = j + dirs[d][1];

                        if (isInBound(nr, nc, n) && grid[nr][nc] == 1) {
                            int adjNodeNo = convertTo1D(nr, nc, n);
                            int parent = ds.find(adjNodeNo);

                            hs.add(parent);
                        }
                    }
                    int ans = 0;
                    for (int ele : hs) {
                        ans += ds.size[ele];
                    }
                    max = Math.max(ans + 1, max);
                } else {
                    max = Math.max(ds.size[ds.find(nodeNo)], max);
                }
            }
        }

        return max;
    }
}

/*
------------------------------------------
Time Complexity:
- Building connected components:
    O(n^2 * ackerman(n^2))
    (Each cell might do up to 4 unions/finds.)
    
- Checking each 0 cell:
    O(n^2 * 4 * ackerman(n^2)) approx O(n^2 * ackerman(n^2))

Overall time: O(n^2 * ackerman(n^2))

ackerman(n) is the inverse Ackermann function, practically constant (approx <= 4 or 5).

Space Complexity:
- Disjoint Set parent and size arrays -> O(n^2)
- Grid and other variables -> O(n^2)
- HashSet in worst case size O(n^2) if many neighbors belong to different components.

Overall space: O(n^2)
------------------------------------------
*/
