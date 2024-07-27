class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        long graph[][] = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 100000001);
            graph[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            long w = cost[i];

            graph[u][v] = Math.min(w, graph[u][v]);
        }
        // warshall st
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        // warshall end
        int strLen = target.length();
        long ans = 0;

        for (int i = 0; i < strLen; i++) {
            int src = source.charAt(i) - 'a';
            int dest = target.charAt(i) - 'a';

            if (src != dest) {
                long c = graph[src][dest];
                if (c < 100000001) {
                    ans += c;
                } else {
                    ans = -1;
                    break;
                }
            }
        }
        return ans;
    }
}
