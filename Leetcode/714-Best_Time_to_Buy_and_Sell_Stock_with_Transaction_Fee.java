class Solution {
    public int find(int i, int cB, int prices[], int n, int fee, int dp[][]) {
        if (i == n)
            return 0;
        if (dp[i][cB] != -1) {
            return dp[i][cB];
        }
        int max = 0;
        if (cB == 1) {
            max = Math.max(
                    -(prices[i] + fee) + find(i + 1, 0, prices, n, fee, dp),
                    find(i + 1, 1, prices, n, fee, dp));
        } else {
            max = Math.max(
                    prices[i] + find(i + 1, 1, prices, n, fee, dp),
                    find(i + 1, 0, prices, n, fee, dp));
        }

        return dp[i][cB] = max;
    }

    public int maxProfit(int[] prices, int fee) {
        // int n = prices.length;

        // int dp[][] = new int[n][2];
        // for(int d[]:dp){
        //     Arrays.fill(d,-1);
        // }

        // return find(0,1,prices,n,fee,dp);

        // tabulation 

        // int n = prices.length;

        // int dp[][] = new int[n + 1][2];

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int cB = 0; cB <= 1; cB++) {
        //         int max = 0;
        //         if (cB == 1) {
        //             max = Math.max(
        //                     -(prices[i] + fee) + dp[i + 1][0],
        //                     dp[i + 1][1]);
        //         } else {
        //             max = Math.max(
        //                     prices[i] + dp[i + 1][1],
        //                     dp[i + 1][0]);
        //         }

        //         dp[i][cB] = max;
        //     }
        // }
        // return dp[0][1];

        // opt

        // int n = prices.length;

        // int ahead[] = new int[2];
        // int curr[] = new int[2];

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int cB = 0; cB <= 1; cB++) {
        //         if (cB == 1) {
        //             curr[cB] = Math.max(
        //                     -(prices[i] + fee) + ahead[0],
        //                     ahead[1]);
        //         } else {
        //             curr[cB] = Math.max(
        //                     prices[i] + ahead[1],
        //                     ahead[0]);
        //         }
        //     }
        //     ahead = curr;
        // }
        // return curr[1];

        // opt 2

        int n = prices.length;

        int aheadBuy = 0;
        int aheadNotBuy = 0;
        int currBuy = 0;
        int currNotBuy = 0;

        for (int i = n - 1; i >= 0; i--) {

            currBuy = Math.max(-(prices[i] + fee) + aheadNotBuy, aheadBuy);

            currNotBuy = Math.max(prices[i] + aheadBuy, aheadNotBuy);


            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;

        }
        return currBuy;
    }
}