class Solution {
    private int dp[][];

    private int solve(int prices[], int i, int canBuy, int n) {
        if (i == n) {
            return 0;
        }
        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                -prices[i] + solve(prices, i + 1, 0, n), 
                            solve(prices, i + 1, 1, n));
        } else {
             profit = Math.max(
                prices[i] + solve(prices, i + 1, 1, n), 
                            solve(prices, i + 1, 0, n));
        }

        return dp[i][canBuy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int d[]: dp){
        Arrays.fill(d,-1);
        }
        return solve(prices,0, 1, n);
        // for (int i = n-1; i >= 0; i--) {
        //     long profit = 0;
        //     for (int canBuy = 0; canBuy <= 1; canBuy++) {
        //         if (canBuy == 1) {
        //             dp[i][canBuy] = Math.max(
        //                     profit + (-prices[i] + dp[i + 1][0]), profit + dp[i + 1][1]);
        //         } else {
        //             dp[i][canBuy] = Math.max(
        //                     profit + (prices[i] + dp[i + 1][1]), profit + dp[i + 1][0]);
        //         }
        //     }

        // }

        // return profit;
    }
}