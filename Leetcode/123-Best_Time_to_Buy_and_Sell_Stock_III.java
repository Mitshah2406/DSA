class Solution {
    private int dp[][][];
    private int dp2[][];

    private int memo3dSolve(int prices[], int i, int canBuy, int cap, int n) {
        if (i == n || cap == 0) {
            return 0;
        }
        if (dp[i][canBuy][cap] != -1) {
            return dp[i][canBuy][cap];
        }
        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    (-prices[i] + memo3dSolve(prices, i + 1, 0, cap, n)),
                    memo3dSolve(prices, i + 1, 1, cap, n));
        } else {
            profit = Math.max(
                    (prices[i] + memo3dSolve(prices, i + 1, 1, cap - 1, n)),
                    memo3dSolve(prices, i + 1, 0, cap, n));
        }

        return dp[i][canBuy][cap] = profit;
    }

    private int memo3d(int prices[], int n) {
        dp = new int[n][2][3];
        for (int d1[][] : dp) {
            for (int d2[] : d1) {
                Arrays.fill(d2, -1);
            }
        }
        return memo3dSolve(prices, 0, 1, 2, n);
    }

    private int tabulation3d(int prices[], int n) {
        dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        dp[i][buy][cap] = Math.max(
                                (-prices[i] + dp[i + 1][0][cap]),
                                dp[i + 1][1][cap]);
                    } else {
                        dp[i][buy][cap] = Math.max(
                                (prices[i] + dp[i + 1][1][cap - 1]),
                                dp[i + 1][0][cap]);
                    }
                }
            }

        }

        return dp[0][1][2];
    }

    private int optimized2d(int prices[], int n) {
        int curr[][] = new int[2][3];
        int next[][] = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        curr[buy][cap] = Math.max(
                                (-prices[i] + next[0][cap]),
                                next[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(
                                (prices[i] + next[1][cap - 1]),
                                next[0][cap]);
                    }
                }
            }
            next = curr;
        }

        return curr[1][2];
    }

    private int memo2dSolve(int i, int transaction, int prices[], int n) {
        if (i == n || transaction == 4) {
            return 0;
        }

        if (dp2[i][transaction] != -1) {
            return dp2[i][transaction];
        }

        int profit = 0;
        if (transaction % 2 == 0) {
            profit = Math.max(-prices[i] + memo2dSolve(i + 1, transaction + 1, prices, n),
                    0 + memo2dSolve(i + 1, transaction, prices, n));
        } else {
            profit = Math.max(prices[i] + memo2dSolve(i + 1, transaction + 1, prices, n),
                    0 + memo2dSolve(i + 1, transaction, prices, n));
        }

        return dp2[i][transaction] = profit;
    }

    private int memo2d(int prices[], int n) {
        dp2 = new int[n][4];

        // n*4 coz we have four states in total if we keep cap in mid
        // i.e Buy Sell Buy Sell (0,1,2,3)
        // so even is Buy state
        // odd is Sell State

        for (int d[] : dp2) {
            Arrays.fill(d, -1);
        }
        return memo2dSolve(0, 0, prices, n);
    }

    private int tabulation2d(int prices[], int n) {
        dp2 = new int[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {
            for (int transaction = 3; transaction >= 0; transaction--) {
                if (transaction % 2 == 0) {
                    dp2[i][transaction] = Math.max(
                            -prices[i] + dp2[i + 1][transaction + 1],
                            0 + dp2[i + 1][transaction]);
                } else {
                    dp2[i][transaction] = Math.max(
                            prices[i] + dp2[i + 1][transaction + 1],
                            0 + dp2[i + 1][transaction]);
                }
            }
        }

        return dp2[0][0];
    }

    private int optimized1d(int prices[], int n) {
        int curr[] = new int[5];
        int next[] = new int[5];

        for (int i = n - 1; i >= 0; i--) {
            for (int transaction = 3; transaction >= 0; transaction--) {
                if (transaction % 2 == 0) {
                    curr[transaction] = Math.max(
                            -prices[i] + next[transaction + 1],
                            0 + next[transaction]);
                } else {
                    curr[transaction] = Math.max(
                            prices[i] + next[transaction + 1],
                            0 + next[transaction]);
                }
            }
            next = curr;
        }

        return curr[0];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // return memo3d(prices, n);
        // return tabulation3d(prices, n);
        // return optimized2d(prices, n);
        // return memo2d(prices, n);
        // return tabulation2d(prices, n);
        return optimized1d(prices, n);

    }
}
