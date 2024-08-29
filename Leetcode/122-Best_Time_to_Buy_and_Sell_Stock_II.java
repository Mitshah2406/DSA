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

        // memoization

        // dp = new int[n][2];
        // for(int d[]: dp){
        // Arrays.fill(d,-1);
        // }
        // return solve(prices,0, 1, n);


        // tabulation Method 
        // dp = new int[n+1][2];

        // for(int i=n-1;i>=0;i--){
        //     int profit = 0;
        //     for(int buy=0;buy<=1;buy++){
        //         if(buy==1){
        //             profit = Math.max( -prices[i] + dp[i+1][0], dp[i+1][1]);
        //         }else{
        //             profit = Math.max(prices[i] + dp[i+1][1], dp[i+1][0]);
        //         }
        //     dp[i][buy] = profit;
        //     }
        // }

        // return dp[0][1]; --> this [0][1] came from line ref of line 35

        // --> Optimized Version 
        // at any instance of time we need just 4 cells i.e (curr 2 cells, and next 2 cells)
        // so modify the logic accordingly
        int next[] = new int[2];
        int curr[] = new int[2];

        for(int i=n-1;i>=0;i--){
            int profit = 0;
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    profit = Math.max( -prices[i] + next[0], next[1]);
                }else{
                    profit = Math.max(prices[i] + next[1], next[0]);
                }
                curr[buy] = profit; // ref from line 49
            }
                next = curr;
        }

        return curr[1]; // ref from line 35, and 53 (use curr/next anything will give same ans)
    }
}