class Solution {
    public boolean find(int i, int j, int k, String s1, String s2, String s3, Boolean dp[][]) {
        if (k < 0) {
            return true;
        }
        if (i >= 0 && j >= 0 && dp[i][j] != null) {
            return dp[i][j];
        }
        boolean ans = false;
        if (i >= 0 && s1.charAt(i) == s3.charAt(k)) {
            ans = find(i - 1, j, k - 1, s1, s2, s3, dp);
        }
        if (!ans && j >= 0 && s2.charAt(j) == s3.charAt(k)) {
            ans = find(i, j - 1, k - 1, s1, s2, s3, dp);
        }
        if (i >= 0 && j >= 0) {
            dp[i][j] = ans;
        }
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // int n = s1.length();
        // int m = s2.length();
        // int o = s3.length();
        // if (n + m != o) {
        //     return false;
        // }
        // Boolean dp[][] = new Boolean[n][m];
        // return find(n - 1, m - 1, o - 1, s1, s2, s3, dp);



        int n = s1.length();
        int m = s2.length();
        int o = s3.length();
        if (n + m != o) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int k = i + j - 1; // last used char in s3 as s3 is sum of s1 and s2, therefore k=i+j-1
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}