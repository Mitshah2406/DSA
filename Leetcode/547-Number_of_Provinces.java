class Solution {
    public void dfs(int arr[][], boolean vis[], int i, int n) {
        vis[i] = true;

        for (int k=0;k<n;k++) {
            if(!vis[k] && arr[i][k]==1){
                dfs(arr,vis,k,n);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // Not the most optimal but multi source DFS
        // can also do with adj list construction

        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(isConnected, vis, i, n);
                ans++;
            }
        }

        return ans;
    }
}