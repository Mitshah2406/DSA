class Solution {
    public int countCoins(int i, int amt, int coins[], int dp[][]) {
        if (i == 0) {
            if (amt % coins[i] == 0)
                return amt / coins[i];
            else
                return (int) 1e9;
        }
        if (dp[i][amt] != -1) {
            return dp[i][amt];
        }
        int notTake = 0 + countCoins(i - 1, amt, coins, dp);
        int take = Integer.MAX_VALUE;
        if (coins[i] <= amt) {
            take = 1 + countCoins(i, amt - coins[i], coins, dp);
        }

        return dp[i][amt] = Math.min(notTake, take);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // int dp[][] = new int[n][amount + 1];
        // for(int d[]: dp) Arrays.fill(d,-1);
        // int min = countCoins(n-1, amount, coins, dp);
        // return min==1e9 ? -1 : min;

        // ==> TABULATION WITHOUT SPACE OPTIMIZATION
        // 1. Write Base Case
        // 2. Changing Variables (Take it reverse order (if n->0 then 0->n for curr) , (if n->0 then 0->n for amount))
        // 3. Copy the remaining and change the recurrence reln to dp table.

        // Base Case for the 0th coin (checking for all amount left)
        // int dp[][] = new int[n][amount + 1];
        // for (int amt = 0; amt <= amount; amt++) {
        //     if (amt % coins[0] == 0)
        //         dp[0][amt] = amt / coins[0];
        //     else
        //         dp[0][amt] = (int) 1e9;
        // }

        // for (int i = 1; i < n; i++) {
        //     for (int amt = 0; amt <= amount; amt++) {
        //         // just copy the recurrences from memoization and paste and just change to dp table
        //         int notTake = dp[i - 1][amt];
        //         int take = (int) 1e9;
        //         if (coins[i] <= amt) {
        //             take = 1 + dp[i][amt - coins[i]];
        //         }

        //         dp[i][amt] = Math.min(notTake, take);
        //     }
        // }

        // int ans = dp[n - 1][amount];
        // return ans >= 1e9 ? -1 : ans;

        // ==> TABULATION WITH SPACE OPTIMIZATION
        // Classic problem where we need i-1, and i that means prev and curr
        // in base case we have to first calc prev as it is first idx
        // then for other we calc for all amounts, we assign curr to prev, and continue
        // in this way dp[n-1][amount] which means prev[amount] is where ans is stored
        int prev[] = new int[amount + 1];
        int curr[] = new int[amount + 1];

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                prev[amt] = amt / coins[0];
            else
                prev[amt] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int amt = 0; amt <= amount; amt++) {
                // just copy the recurrences from memoization and paste and just change to dp table
                int notTake = prev[amt];
                int take = (int) 1e9;
                if (coins[i] <= amt) {
                    take = 1 + curr[amt - coins[i]];
                }

                curr[amt] = Math.min(notTake, take);
            }
            prev = curr;
        }

        int ans = prev[amount];
        return ans >= 1e9 ? -1 : ans;
    }
}