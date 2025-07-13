class Solution {
    public int countWays(int i, int j, int dp[][]) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = countWays(i, j - 1, dp);
        int up = countWays(i - 1, j, dp);

        return dp[i][j] = left + up;
    }

    public int uniquePaths(int m, int n) {
        // int dp[][] = new int[m][n];
        // for(int d[]:dp){
        //     Arrays.fill(d,-1);
        // }
        // return countWays(m-1, n-1, dp);

        // Tabulation without space optimization

        // int dp[][] = new int[m][n];

        // // Base cases
        // dp[0][0] = 1;
        // int neg = 0;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == 0 && j == 0)
        //             continue;
        //         int left = (j - 1 < 0) ? neg : dp[i][j - 1];
        //         int up = (i - 1 < 0) ? neg : dp[i - 1][j];

        //         dp[i][j] = left + up;
        //     }
        // }
        // return dp[m - 1][n - 1];


         // Tabulation without space optimization
        int prev[] = new int[n];
        int curr[] = new int[n];
        curr[0] = 1;
        int neg = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int up = (i - 1 < 0) ? neg : prev[j];
                int left = (j - 1 < 0) ? neg : curr[j-1];

                curr[j] = left + up;
            }
            prev = curr;
        }
        return prev[n-1];
    }
}