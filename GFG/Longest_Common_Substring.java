class Solution {
    private int maxLen;

    private int longestCommonSubstringUtil(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + longestCommonSubstringUtil(s1, s2, i - 1, j - 1, dp);
            if (dp[i][j] > maxLen) {
                maxLen = dp[i][j];
            }
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }

    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        maxLen = 0;

        // Initialize dp with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        // Explore all combinations of i, j
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                longestCommonSubstringUtil(s1, s2, i, j, dp);
            }
        }

        return maxLen;
    }
}
