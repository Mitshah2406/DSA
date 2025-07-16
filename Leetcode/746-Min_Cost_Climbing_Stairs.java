class Solution {
    public int findMinCost(int i, int n, int cost[], int dp[]) {
        if (i == 0 || i == 1) {
            return cost[i];
        }
        if (dp[i] != -1)
            return dp[i];
        int climbOne = findMinCost(i - 1, n, cost, dp);
        int climbTwo = findMinCost(i - 2, n, cost, dp);

        return dp[i] = Math.min(climbOne, climbTwo) + (i == n ? 0 : cost[i]);
    }

    public int minCostClimbingStairs(int[] cost) {

        /*
        Approach	            Time Complexity	Space Complexity
        Memoization (Top-Down)	O(n)	        O(n)+O(n)=O(2n)
        Tabulation (Bottom-Up)	O(n)	        O(n)
        Space-Optimized	        O(n)	        O(1)
        */
        // int n = cost.length;
        // int dp[] = new int[n + 2];
        // Arrays.fill(dp, -1);
        // return findMinCost(n, n, cost, dp);
        // return Math.min(findMinCost(0, n, cost, dp1), findMinCost(1,n,cost,dp2));

        // tabulation
        // int n = cost.length;
        // int dp[] = new int[n + 2];
        // // Arrays.fill(dp, -1);
        // // return findMinCost(n, n, cost, dp);
        // dp[0] = cost[0];
        // dp[1] = cost[1];
        // for (int i = 2; i <= n; i++) {
        //     int climbOne = dp[i - 1];
        //     int climbTwo = dp[i - 2];

        //      dp[i] = Math.min(climbOne, climbTwo) + (i == n ? 0 : cost[i]);

        // }
        // return dp[n];

        // space opt

        int n = cost.length;
        // dp[0] = cost[0];
        // dp[1] = cost[1];
        int m2 = cost[0];
        int m1 = cost[1];
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            int climbOne = m1;
            int climbTwo = m2;

            curr = Math.min(climbOne, climbTwo) + (i == n ? 0 : cost[i]);
            m2 = m1;
            m1 = curr;
        }

        return curr;
    }
}