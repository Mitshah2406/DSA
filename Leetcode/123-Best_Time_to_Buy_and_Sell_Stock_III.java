class Solution {
    public int find3d(int i, int canBuy, int noOfTR, int prices[], int n, int dp[][][]) {
        if (i == n || noOfTR == 0) {
            return 0;
        }
        if (dp[i][canBuy][noOfTR] != -1) {
            return dp[i][canBuy][noOfTR];
        }
        int max = 0;
        if (canBuy == 1) {
            if (noOfTR > 0) {
                int buy = -prices[i] + find3d(i + 1, 0, noOfTR, prices, n, dp);
                int dontBuy = find3d(i + 1, 1, noOfTR, prices, n, dp);
                max = Math.max(buy, dontBuy);
            }
        } else {
            int sell = prices[i] + find3d(i + 1, 1, noOfTR - 1, prices, n, dp);
            int dontSell = find3d(i + 1, canBuy, noOfTR, prices, n, dp);
            max = Math.max(sell, dontSell);
        }

        return dp[i][canBuy][noOfTR] = max;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int dp[][][] = new int[n][2][3];
        // for(int d1[][]: dp){
        //     for(int d2[]: d1){
        //         Arrays.fill(d2,-1);
        //     }
        // }
        // return find3d(0, 1, 2, prices, n, dp);

        // int dp[][][] = new int[n + 1][2][3];


        // for (int i = n - 1; i >= 0; i--) {
        //     for (int canBuy = 0; canBuy <= 1; canBuy++) {
        //         for (int noOfTR = 1; noOfTR <= 2; noOfTR++) {
        //             if (canBuy == 1) {
        //                 dp[i][1][noOfTR] = Math.max(-prices[i] + dp[i + 1][0][noOfTR], dp[i + 1][1][noOfTR]);
        //             } else {
        //                 dp[i][0][noOfTR] = Math.max(prices[i] + dp[i + 1][1][noOfTR - 1], dp[i + 1][0][noOfTR]);
        //             }
        //         }
        //     }
        // }
        // return dp[0][1][2];


        // Space optimal 
        /*
        Time = O(n*2*3)
        Space = (2+3)
         */
        int ahead[][] = new int[2][3];
        int curr[][] = new int[2][3];


        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int noOfTR = 1; noOfTR <= 2; noOfTR++) {
                    if (canBuy == 1) {
                        curr[1][noOfTR] = Math.max(-prices[i] + ahead[0][noOfTR], ahead[1][noOfTR]);
                    } else {
                        curr[0][noOfTR] = Math.max(prices[i] + ahead[1][noOfTR - 1], ahead[0][noOfTR]);
                    }
                }
            }
            ahead = curr;
        }
        return curr[1][2];
    }
}