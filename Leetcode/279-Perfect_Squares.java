class Solution {
    public int find(int i, int n, int dp[][]) {
        if (n == 0) {
            // System.out.println("Returning..");
            return 0;
        }
        if (i <= 0 || n < 0) {
            return (int) 1e9;
        }
        if (dp[i][n] != -1) {
            return dp[i][n];
        }
        int take = (int) 1e9;
        // System.out.println(i);
        if (i * i <= n) {
            // System.out.println("take" + i + "pending" + (n - i * i) + "with og " + n);
            int rem = n - (i * i);
            if (i * i <= rem) {
                take = 1 + find(i, rem, dp);
            } else {
                take = 1 + find(i - 1, rem, dp);
            }
        }
        int skip = find(i - 1, n, dp);

        return dp[i][n] = Math.min(take, skip);
    }

    public int findOpt(int n, int dp[]) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int smallest = (int) 1e9;
        for (int i = 1; i * i <= n; i++) {
            int take = findOpt(n - i * i, dp);
            smallest = Math.min(take, smallest);
        }

        return dp[n] = smallest + 1;
    }

    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return findOpt(n, dp);

       
        // if (n == 1) {
        //     return 1;
        // }
        // int limit = (int) Math.sqrt(n);
        // int dp[][] = new int[limit + 1][n + 1];
        // for (int d[] : dp) {
        //     Arrays.fill(d, -1);
        // }
        // return find(limit, n, dp);

        // if (n == 1) {
        //     return 1;
        // }
        // // for (int d[] : dp) {
        // //     Arrays.fill(d, -1);
        // // }

        // // return find(n / 2, n, dp);
        // int limit = (int) Math.sqrt(n);
        // int dp[][] = new int[limit + 1][n + 1];
        // Arrays.fill(dp[0], (int) 1e9);
        // dp[0][0] = 0;
        // for (int i = 1; i <= limit; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         int take = (int) 1e9;
        //         if (i * i <= j) {
        //             int rem = j - (i * i);
        //             if (i * i <= rem) {
        //                 take = 1 + dp[i][rem];
        //             } else {
        //                 take = 1 + dp[i - 1][rem];
        //             }
        //         }
        //         int skip = dp[i - 1][j];

        //         dp[i][j] = Math.min(take, skip);
        //     }
        // }

        // return dp[limit][n];

        // if (n == 1) {
        //     return 1;
        // }
        // int limit = (int) Math.sqrt(n);
        // // int dp[][] = new int[limit + 1][n + 1];
        // int prev[] = new int[n + 1];
        // int curr[] = new int[n + 1];
        // // Arrays.fill(dp[0], (int) 1e9);
        // // dp[0][0] = 0;
        // // 0[0,1e9,1e9]
        // // 1[0,0,0]
        // // 2[0,0,0]
        // Arrays.fill(prev, (int)1e9);
        // prev[0] = 0;

        // for (int i = 1; i <= limit; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         int take = (int) 1e9;
        //         if (i * i <= j) {
        //             int rem = j - (i * i);
        //             if (i * i <= rem) {
        //                 take = 1 + curr[rem];
        //             } else {
        //                 take = 1 + prev[rem];
        //             }
        //         }
        //         int skip = prev[j];

        //         curr[j] = Math.min(take, skip);
        //     }
        //     prev = curr.clone();
        // }

        // return prev[n];
    }
}