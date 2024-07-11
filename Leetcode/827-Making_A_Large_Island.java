//Hard

// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

// Return the size of the largest island in grid after applying this operation.

// An island is a 4-directionally connected group of 1s.

 

// Example 1:

// Input: grid = [[1,0],[0,1]]
// Output: 3
// Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
// Example 2:

// Input: grid = [[1,1],[1,0]]
// Output: 4
// Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
// Example 3:

// Input: grid = [[1,1],[1,1]]
// Output: 4
// Explanation: Can't change any 0 to 1, only one island with area = 4.
 

// Constraints:

// n == grid.length
// n == grid[i].length
// 1 <= n <= 500
// grid[i][j] is either 0 or 1.

// Link -->https://leetcode.com/problems/making-a-large-island/description/
// Explanation --> https://www.youtube.com/watch?v=lgiz0Oup6gM&t=974s


//soln

class DisjointSet {
    public int[] rank, parent, size;

    public DisjointSet(int n) {
        rank = new int[n + 1];
        Arrays.fill(rank,0);
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i]=1;
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }

    public void unionByRank(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if (pu == pv)
            return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if (pu == pv)
            return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    public static boolean isValid(int row, int col, int n) {
        return (row >= 0) && (col < n) && (row < n) && (col >= 0);
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        // connecting the 1's waale components

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    continue; // dont do anything
                // go in 4 directions
                int dr[] = { 0, 0, -1, 1 };
                int dc[] = { -1, 1, 0, 0 };
                for (int d = 0; d < 4; d++) {
                    int nr = row + dr[d];
                    int nc = col + dc[d];

                    if (isValid(nr, nc, n) && grid[nr][nc] == 1) {
                        int currentNodeNo = row * n + col;
                        int discoveredNodeNo = nr * n + nc;
                        ds.unionBySize(currentNodeNo, discoveredNodeNo);
                    }
                }
            }
        }

        // check by adding zeros
        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue; // if 1 dont make it zero

                HashSet<Integer> components = new HashSet<Integer>();
                int dr[] = { 0, 0, -1, 1 };
                int dc[] = { -1, 1, 0, 0 };
                for (int d = 0; d < 4; d++) {
                    int nr = row + dr[d];
                    int nc = col + dc[d];

                    if (isValid(nr, nc, n)) {
                        if (grid[nr][nc] == 1) {
                            int discoveredNodeNo = nr * n + nc;
                            int ans = ds.findUltimateParent(discoveredNodeNo);
                            components.add(ans);
                        }
                    }
                }
                int sizeT = 0;
                for (int h : components) {
                    sizeT += ds.size[h];
                }
                mx = Math.max(sizeT + 1, mx);
            }
        }
        for (int cell = 0; cell < (n * n); cell++) {
            mx = Math.max(ds.size[ds.findUltimateParent(cell)], mx);
        }
        return mx;
    }
}


//TC - O(n^2)

//SC - O(n)