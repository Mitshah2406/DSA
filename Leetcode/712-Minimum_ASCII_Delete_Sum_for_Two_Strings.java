class Solution {
    private int lcs(int i, int j, String s1, String s2, int dp[][]) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = s1.charAt(i) + lcs(i - 1, j - 1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(lcs(i - 1, j, s1, s2, dp), lcs(i, j - 1, s1, s2, dp));
    }

    public int minimumDeleteSum(String s1, String s2) {
        // int totalAscii = 0;
        // int n = s1.length();
        // int m = s2.length();
        // int dp[][] = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        //     totalAscii += s1.charAt(i);
        // }
        // for (int j = 0; j < m; j++) {
        //     totalAscii += s2.charAt(j);
        // }

        // int include = lcs(n - 1, m - 1, s1, s2, dp);
        // return totalAscii - (include * 2);

        // int totalAscii = 0;
        // int n = s1.length();
        // int m = s2.length();
        // int dp[][] = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     totalAscii += s1.charAt(i);
        // }
        // for (int j = 0; j < m; j++) {
        //     totalAscii += s2.charAt(j);
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (s1.charAt(i) == s2.charAt(j)) {
        //             dp[i][j] = s1.charAt(i);
        //             if (i > 0 && j > 0) {
        //                 dp[i][j] += dp[i - 1][j - 1];
        //             }
        //         } else {
        //             int rM1 = i > 0 ? dp[i-1][j] : 0;
        //             int cM1 = j > 0 ? dp[i][j-1] : 0;
        //             dp[i][j] = Math.max(rM1,cM1);
        //         }
        //     }
        // }
        // int include = dp[n - 1][m - 1];
        // return totalAscii - (include * 2);

        int totalAscii = 0;
        int n = s1.length();
        int m = s2.length();
        // int dp[][] = new int[n][m];
        int prev[] = new int[m];
        int curr[] = new int[m];
        for (int i = 0; i < n; i++) {
            totalAscii += s1.charAt(i);
        }
        for (int j = 0; j < m; j++) {
            totalAscii += s2.charAt(j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    curr[j] = s1.charAt(i);
                    if (i > 0 && j > 0) {
                        curr[j] += prev[j - 1];
                    }
                } else {
                    int rM1 = i > 0 ? prev[j] : 0;
                    int cM1 = j > 0 ? curr[j - 1] : 0;
                    curr[j] = Math.max(rM1, cM1);
                }
            }
            int t[] = prev;
            prev = curr;
            curr = t;
        }
        int include = prev[m - 1];
        return totalAscii - (include * 2);
    }
}