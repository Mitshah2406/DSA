class Solution {
    private int lcs(int i, int j, String word1, String word2, int dp[][]) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 1 + lcs(i - 1, j - 1, word1, word2, dp);
        }

        return dp[i][j] = Math.max(lcs(i - 1, j, word1, word2, dp), lcs(i, j - 1, word1, word2, dp));
    }

    public int minDistance(String word1, String word2) {
        // idea - find lcs, return (n-lcs)+(m-lcs)

        // int n = word1.length();
        // int m = word2.length();
        // int dp[][] = new int[n][m];
        // for (int d[] : dp) {
        //     Arrays.fill(d, -1);
        // }
        // int ans = lcs(n - 1, m - 1, word1, word2, dp);
        // return (n - ans) + (m - ans);

        // int n = word1.length();
        // int m = word2.length();
        // int dp[][] = new int[n + 1][m + 1];
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= m; j++) {
        //         if (word1.charAt(i-1) == word2.charAt(j-1)) {
        //             dp[i][j] = 1 + dp[i - 1][j - 1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }
        // int ans = dp[n][m];
        // return (n - ans) + (m - ans);

        int n = word1.length();
        int m = word2.length();
        // int dp[][] = new int[n + 1][m + 1];
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        int ans = prev[m];
        return (n - ans) + (m - ans);
    }

    /*
    | Approach                   | Time Complexity | Space Complexity |
    | -------------------------- | --------------- | ---------------- |
    | Recursion (No Memo)        | O(2^(n + m))  | O(n + m)       |
    | Recursion + Memoization    | O(n * m)      | O(n * m)       |
    | Tabulation (2D DP)         | O(n * m)      | O(n * m)       |
    | Space-Optimized Tabulation | O(n * m)      | O(m)           |

     */
}