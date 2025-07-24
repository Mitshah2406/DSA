class Solution {
    public int find(int i, int j, String word1, String word2, int dp[][]) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = (int) 1e9;
        if (word1.charAt(i) != word2.charAt(j)) {
            int insert = find(i, j - 1, word1, word2, dp);
            int delete = find(i - 1, j, word1, word2, dp);
            int replace = find(i - 1, j - 1, word1, word2, dp);
            return dp[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
        } else {
            return dp[i][j] = find(i - 1, j - 1, word1, word2, dp);
        }
    }

    public int minDistance(String word1, String word2) {
        // int n = word1.length();
        // int m = word2.length();
        // int dp[][] = new int[n][m];
        // for (int d[] : dp) {
        //     Arrays.fill(d, -1);
        // }
        // return find(n - 1, m - 1, word1, word2, dp);

        // int n = word1.length();
        // int m = word2.length();
        // int dp[][] = new int[n + 1][m + 1];
        // // base cases
        // for (int i = 0; i <= m; i++) {
        //     dp[0][i] = i;
        // }
        // for (int i = 0; i <= n; i++) {
        //     dp[i][0] = i;
        // }
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= m; j++) {
        //         if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
        //             int insert = dp[i][j - 1];
        //             int delete = dp[i - 1][j];
        //             int replace = dp[i - 1][j - 1];
        //             dp[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
        //         } else {
        //             dp[i][j] = dp[i - 1][j - 1];
        //         }
        //     }
        // }
        // return dp[n][m];


        int n = word1.length();
        int m = word2.length();
        // int dp[][] = new int[n + 1][m + 1];
        int curr[] = new int[m+1];
        int prev[] = new int[m+1];
        // base cases
        // for (int i = 0; i <= m; i++) {
        //     dp[0][i] = i;
        // }
        // for (int i = 0; i <= n; i++) {
        //     dp[i][0] = i;
        // }
        for (int i = 0; i <= m; i++) {
            prev[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    int insert = curr[j - 1];
                    int delete = prev[j];
                    int replace = prev[j - 1];
                    curr[j] = Math.min(Math.min(insert, delete), replace) + 1;
                } else {
                    curr[j] = prev[j - 1];
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}