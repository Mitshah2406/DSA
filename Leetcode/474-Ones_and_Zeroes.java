class Solution {
    public int find(int i, int m, int n, int zeroCount[], int oneCount[], int dp[][][]) {
        //      Time Complexity:
        // States: i (0 to size), m (0 to m), n (0 to n) -> Total = O(size * m * n)

        // TC = O(size × m × n)

        //  Space Complexity:
        // DP table of size × (m+1) × (n+1) -> O(size × m × n)

        // Plus recursion stack depth of O(size) (in worst case).

        // SC = O(size × m × n) + O(size)

        if (i == oneCount.length || m < 0 || n < 0) {
            return 0;
        }
        if (dp[i][m][n] != -1)
            return dp[i][m][n];
        int take = 0;
        if (m - zeroCount[i] >= 0 && n - oneCount[i] >= 0) {
            take = 1 + find(i + 1, m - zeroCount[i], n - oneCount[i], zeroCount, oneCount, dp);
        }
        int skip = 0 + find(i + 1, m, n, zeroCount, oneCount, dp);

        return dp[i][m][n] = Math.max(take, skip);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // int size = strs.length;
        // int oneCount[] = new int[size];
        // int zeroCount[] = new int[size];
        // int dp[][][] = new int[size + 1][m + 1][n + 1];
        // for (int d1[][] : dp) {
        //     for (int d2[] : d1) {
        //         Arrays.fill(d2, -1);
        //     }
        // }
        // for (int k = 0; k < size; k++) {
        //     int sL = strs[k].length();
        //     for (int i = 0; i < sL; i++) {
        //         char curr = strs[k].charAt(i);
        //         if (curr == '0') {
        //             zeroCount[k]++;
        //         } else {
        //             oneCount[k]++;
        //         }
        //     }
        // }

        // return find(0, m, n, zeroCount, oneCount, dp);

        // // Tabulation
        // Time = O(m*n*size)
        // Space = O(m*n*size)

        // int size = strs.length;
        // int oneCount[] = new int[size];
        // int zeroCount[] = new int[size];
        // int dp[][][] = new int[size+1][m + 1][n + 1];
        // // for (int d1[][] : dp) {
        // //     for (int d2[] : d1) {
        // //         Arrays.fill(d2, -1);
        // //     }
        // // }
        // for (int k = 0; k < size; k++) {
        //     int sL = strs[k].length();
        //     for (int i = 0; i < sL; i++) {
        //         char curr = strs[k].charAt(i);
        //         if (curr == '0') {
        //             zeroCount[k]++;
        //         } else {
        //             oneCount[k]++;
        //         }
        //     }
        // }

        // // return find(0, m, n, zeroCount, oneCount, dp);

        // for (int i = size - 1; i >= 0; i--) {
        //     for (int j = 0; j <=m; j++) {
        //         for (int k = 0; k <= n; k++) {
        //             int take = 0;
        //             if (j - zeroCount[i] >= 0 && k - oneCount[i] >= 0) {
        //                 take = 1 + dp[i + 1][j - zeroCount[i]][k - oneCount[i]];
        //             }
        //             int skip = 0 + dp[i + 1][j][k];

        //             dp[i][j][k] = Math.max(take, skip);
        //         }
        //     }
        // }

        // return dp[0][m][n];

        // // Tabulation - Space Optimization 1
        // Time = O(m*n*size)
        // Space = O(m*n) + O(m*n)
        // int size = strs.length;
        // int oneCount[] = new int[size];
        // int zeroCount[] = new int[size];
        // int curr[][] = new int[m + 1][n + 1];
        // int next[][] = new int[m + 1][n + 1];
        // for (int k = 0; k < size; k++) {
        //     int sL = strs[k].length();
        //     for (int i = 0; i < sL; i++) {
        //         char c = strs[k].charAt(i);
        //         if (c == '0') {
        //             zeroCount[k]++;
        //         } else {
        //             oneCount[k]++;
        //         }
        //     }
        // }

        // for (int i = size - 1; i >= 0; i--) {
        //     for (int j = m; j >=0; j--) {
        //         for (int k = n; k >=0; k--) {
        //             int take = 0;
        //             if (j - zeroCount[i] >= 0 && k - oneCount[i] >= 0) {
        //                 take = 1 +  next[j - zeroCount[i]][k - oneCount[i]];
        //             }
        //             int skip = 0 +  next[j][k];

        //             curr[j][k] = Math.max(take, skip);
        //         }
        //     }
        //     next = curr;
        // }

        // return curr[m][n];

        // Tabulation - Space Optimization 2
        // Time = O(m*n*size)
        // Space = O(m*n)
        int size = strs.length;
        int oneCount[] = new int[size];
        int zeroCount[] = new int[size];
        int dp[][] = new int[m + 1][n + 1];

        for (int k = 0; k < size; k++) {
            int sL = strs[k].length();
            for (int i = 0; i < sL; i++) {
                char c = strs[k].charAt(i);
                if (c == '0') {
                    zeroCount[k]++;
                } else {
                    oneCount[k]++;
                }
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    int take = 0;
                    if (j - zeroCount[i] >= 0 && k - oneCount[i] >= 0) {
                        take = 1 + dp[j - zeroCount[i]][k - oneCount[i]];
                    }
                    int skip = 0 + dp[j][k];

                    dp[j][k] = Math.max(take, skip);
                }
            }
        }

        return dp[m][n];
    }
}