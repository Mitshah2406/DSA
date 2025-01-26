class Solution {
    public boolean dfs(int graph[][], int i, boolean vis[], HashSet<Integer> hs) {
        vis[i] = true;

        // explore nbrs
        int size = graph[i].length;
        boolean isSafe = true;
        for (int val : graph[i]) {
            boolean res = false;
            if (!vis[val]) {
                res = dfs(graph, val, vis, hs);
                isSafe = isSafe && res;
            } else {
                if (hs.contains(val)) {
                    isSafe = isSafe && true;
                } else {
                    isSafe = false;
                }
            }
        }

        if (size == 0 || isSafe) {
            hs.add(i);
            return true;
        }
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean vis[] = new boolean[n];
        HashSet<Integer> arr = new HashSet();
        List<Integer> res = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, arr);
            }
        }
        for (int i : arr) {
            res.add(i);
        }
        Collections.sort(res);
        return res;
    }
}