class Solution {
    private int find(int i, int j, int n, String s, int dp[][]) {
        if (i < 0 || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = 0;

        if (s.charAt(i) == s.charAt(j)) {
            max = 1 + find(i - 1, j + 1, n, s, dp);
        } else {
            max = Math.max(find(i - 1, j, n, s, dp), find(i, j + 1, n, s, dp));
        }
        return dp[i][j] = max;
    }

    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        return n-find(n-1, 0, n, s, dp);
    }
}
// mbadm - d(1), 
// mdabm - b(1), 

// leetcodocteel - 1,1,1,1

// leetcode - 3
// edocteel - 3