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
        int n = prices.length;
        int dp[][] = new int[n][2];
        for (int d[] : dp)
            Arrays.fill(d, -1);
        return find(0, n, prices, 1, dp);
    }
}