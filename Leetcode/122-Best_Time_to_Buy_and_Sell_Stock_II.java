class Solution {
    public int find(int i, int n, int prices[], int canBuy, int dp[][]) {
        if (i == n) {
            return 0;
        }
        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }
        int max = 0;
        if (canBuy == 1) {
            int buy = -prices[i] + find(i + 1, n, prices, 0, dp);
            int skip = find(i + 1, n, prices, 1, dp);
            max = Math.max(buy, skip);
        } else {
            int sell = prices[i] + find(i + 1, n, prices, 1, dp);
            int skip = find(i + 1, n, prices, 0, dp);
            max = Math.max(sell, skip);
        }

        return dp[i][canBuy] = max;
    }

    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int dp[][] = new int[n][2];
        // for (int d[] : dp)
        //     Arrays.fill(d, -1);
        // return find(0, n, prices, 1, dp);

        // ==> TABULATION

        // int n = prices.length;
        // // 1. write base case
        // int dp[][] = new int[n + 1][2];
        // dp[n][0] = dp[n][1] = 0;
        // // 2. list changing parameters

        // for (int i = n-1; i >= 0; i--) {
        //     for (int canBuy = 0; canBuy <= 1; canBuy++) {
        //         int max = 0;
        //         if (canBuy == 1) {
        //             int buy = -prices[i] + dp[i + 1][0];
        //             int skip = dp[i + 1][1];
        //             max = Math.max(buy, skip);
        //         } else {
        //             int sell = prices[i] + dp[i + 1][1];
        //             int skip = dp[i + 1][0];
        //             max = Math.max(sell, skip);
        //         }
        //         dp[i][canBuy] = max;
        //     }
        // }
        // // 3. copy recurrences

        // return dp[0][1];

        // Space optimization

        // int n = prices.length;
        // // 1. write base case
        // // int dp[][] = new int[n + 1][2];
        // // dp[n][0] = dp[n][1] = 0;

        // int prev[] = new int[2];
        // int curr[] = new int[2];

        // // 2. list changing parameters

        // for (int i = n-1; i >= 0; i--) {
        //     for (int canBuy = 0; canBuy <= 1; canBuy++) {
        //         int max = 0;
        //         if (canBuy == 1) {
        //             int buy = -prices[i] + curr[0];
        //             int skip = curr[1];
        //             max = Math.max(buy, skip);
        //         } else {
        //             int sell = prices[i] + curr[1];
        //             int skip = curr[0];
        //             max = Math.max(sell, skip);
        //         }
        //         curr[canBuy] = max;
        //     }
        //     // prev = curr;
        // }
        // // 3. copy recurrences

        // return curr[1];

        // Space opt 2

        int n = prices.length;
        // 1. write base case
        // int dp[][] = new int[n + 1][2];
        // dp[n][0] = dp[n][1] = 0;

        int aheadBuy = 0;
        int aheadNotBuy = 0;
        int currBuy = 0;
        int currNotBuy = 0;

        // 2. list changing parameters

        for (int i = n - 1; i >= 0; i--) {
            // Buy
            currBuy = Math.max(-prices[i] + aheadNotBuy, aheadBuy);
            // Sell
            currNotBuy = Math.max(prices[i] + aheadBuy, aheadNotBuy);

            aheadNotBuy = currNotBuy;
            aheadBuy = currBuy;
        }

        return aheadBuy;
    }
}