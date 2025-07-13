class Solution {
    public int find(int i, int canBuy, int prices[], int n, int dp[][]) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }
        int max = 0;

        if (canBuy == 1) {
            max = Math.max(-prices[i] + find(i + 1, 0, prices, n, dp), find(i + 1, 1, prices, n, dp));
        } else {
            max = Math.max(prices[i] + find(i + 2, 1, prices, n, dp), find(i + 1, 0, prices, n, dp));
        }

        return dp[i][canBuy] = max;
    }

    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int dp[][] = new int[n][2];

        // for (int d[] : dp) {
        //     Arrays.fill(d, -1);
        // }

        // return find(0, 1, prices, n, dp);

        // Tabulation 

        // int n = prices.length;
        // int dp[][] = new int[n + 2][2];

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int canBuy = 0; canBuy <= 1; canBuy++) {
        //         int max = 0;
        //         if (canBuy == 1) {
        //             max = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
        //         } else {
        //             max = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
        //         }
        //         dp[i][canBuy] = max;
        //     }
        // }

        // return dp[0][1];

        // opt 

        // int n = prices.length;
        // int ahead1[] = new int[2];
        // int ahead2[] = new int[2];
        // int curr[] = new int[2];

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int canBuy = 0; canBuy <= 1; canBuy++) {
        //         if (canBuy == 1) {
        //             curr[canBuy] = Math.max(-prices[i] + ahead1[0], ahead1[1]);
        //         } else {
        //             curr[canBuy] = Math.max(prices[i] + ahead2[1], ahead1[0]);
        //         }
        //     }
        //     ahead2 = ahead1.clone();
        //     ahead1 = curr.clone();
        // }

        // return curr[1];

        // opt 2

        int n = prices.length;
        int aheadBuy1 = 0;
        int aheadNotBuy1 = 0;
        int aheadBuy2 = 0;
        int currBuy = 0;
        int currNotBuy = 0;

        for (int i = n - 1; i >= 0; i--) {
            currBuy = Math.max(-prices[i] + aheadNotBuy1, aheadBuy1);
            currNotBuy = Math.max(prices[i] + aheadBuy2, aheadNotBuy1);
            aheadBuy2 = aheadBuy1;
            aheadBuy1 = currBuy;
            aheadNotBuy1 = currNotBuy;
        }

        return currBuy;
    }
}