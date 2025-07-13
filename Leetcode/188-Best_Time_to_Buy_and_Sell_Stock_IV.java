class Solution {
    public int find(int i, int canBuy, int nTr, int prices[], int n, int dp[][][]) {
        if (i == n || nTr == 0) {
            return 0;
        }
        if (dp[i][canBuy][nTr] != -1) {
            return dp[i][canBuy][nTr];
        }
        int max = 0;
        if (canBuy == 1) {
            max = Math.max(-prices[i] + find(i + 1, 0, nTr, prices, n, dp), find(i + 1, 1, nTr, prices, n, dp));
        } else {
            max = Math.max(prices[i] + find(i + 1, 1, nTr - 1, prices, n, dp), find(i + 1, 0, nTr, prices, n, dp));
        }

        return dp[i][canBuy][nTr] = max;
    }

    public int maxProfit(int k, int[] prices) {
        // int n = prices.length;
        // int dp[][][] = new int[n][2][k+1];
        // for(int d1[][]: dp){
        //     for(int d2[]: d1){
        //         Arrays.fill(d2,-1);
        //     }
        // }

        // return find(0,1,k,prices,n, dp);

        // Tabulation

        // int n = prices.length;
        // int dp[][][] = new int[n+1][2][k + 1];
        // // base cases are already 0
        // // for ntr=0, and i==n
        // for (int i = n - 1; i >= 0; i--) {
        //     for (int canBuy = 0; canBuy <= 1; canBuy++) {
        //         for (int nTr = 1; nTr <= k; nTr++) {
        //             int max = 0;
        //             if (canBuy == 1) {
        //                 max = Math.max(-prices[i] + dp[i + 1][0][nTr],
        //                         dp[i + 1][1][nTr]);
        //             } else {
        //                 max = Math.max(prices[i] + dp[i + 1][1][nTr-1],
        //                         dp[i + 1][0][nTr]);
        //             }

        //             dp[i][canBuy][nTr] = max;
        //         }
        //     }
        // }

        // return dp[0][1][k];

        // Space Optimal

        int n = prices.length;
        int ahead[][] = new int[2][k + 1];
        int curr[][] = new int[2][k + 1];
        // base cases are already 0 in ahead
        // for ntr=0, and i==n
        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int nTr = 1; nTr <= k; nTr++) {
                    int max = 0;
                    if (canBuy == 1) {
                        curr[canBuy][nTr] = Math.max(-prices[i] + ahead[0][nTr],
                                ahead[1][nTr]);
                    } else {
                        curr[canBuy][nTr] = Math.max(prices[i] + ahead[1][nTr - 1],
                                ahead[0][nTr]);
                    }

                }
                ahead = curr;
            }
        }

        return curr[1][k];
    }
}