class Solution {
    /*
        Mutli Source BFS
        TIME = O(N+M); where N is number of nodes, m is number of edges
        SPACE = O(N)
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList());
        }

        for (int d[] : dislikes) {
            int u = d[0];
            int v = d[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList();
        int vis[] = new int[n + 1];
        Arrays.fill(vis, -1); // -1, 0 ,1

        for (int src = 1; src <= n; src++) {
            if (vis[src] == -1) {
                vis[src] = 0;
                q.add(src);
                while (!q.isEmpty()) {
                    int rem = q.poll();

                    for (int nbr : adj.get(rem)) {
                        if (vis[nbr] == -1) {
                            vis[nbr] = 1 - vis[rem];
                            q.add(nbr);
                        } else if (vis[nbr] == vis[rem]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}