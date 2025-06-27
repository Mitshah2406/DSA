import java.util.Arrays;

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        // Initially, each node is its own parent (self-rooted)
        // and has rank 1
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            // Path compression
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            // x and y are already connected → adding this edge makes a cycle
            return true;
        }

        // Union by rank
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
        return false;
    }
}

class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        // Disjoint Set data structure to detect cycles
        DisjointSet ds = new DisjointSet(n + 1);

        // Keep track of indegree to detect nodes with two parents
        int[] indegree = new int[n + 1];
        Arrays.fill(indegree, -1);

        int bl1 = -1; // Index of second edge pointing to a node (potentially redundant)
        int bl2 = -1; // Index of first edge pointing to the same node

        // STEP 1 - Find node with indegree 2 (if any)
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (indegree[v] == -1) {
                // First time v is seen → record its incoming edge index
                indegree[v] = i;
            } else {
                // Node v already has one parent, now we see it again → two parents
                bl1 = i;            // index of current edge causing indegree 2
                bl2 = indegree[v];  // index of earlier edge causing indegree 2
                break;
            }
        }

        // STEP 2 - Try to construct tree using DSU, skipping bl1 edge
        for (int i = 0; i < n; i++) {
            if (i == bl1) {
                // Skip second edge to test if removing it resolves the problem
                continue;
            }
            int u = edges[i][0];
            int v = edges[i][1];

            boolean createsCycle = ds.union(u, v);
            if (createsCycle) {
                if (bl1 == -1) {
                    // Case 2: No node with two parents, only a cycle
                    return edges[i];
                } else {
                    // Case 3: Both a cycle and a two-parent node exist
                    // Removing bl1 wasn't enough, so remove bl2
                    return edges[bl2];
                }
            }
        }

        // If no cycle found after skipping bl1, then it's purely a two-parent issue (Case 1)
        // So remove the second edge (bl1)
        return edges[bl1];
    }
}

/*
Time = O(N) + O(N × alpha(N))  = approx O(N)
Space = O(N)
*/
