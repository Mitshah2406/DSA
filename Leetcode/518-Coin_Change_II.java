class Solution {
    public int find(int i, int amount, int coins[], int dp[][]) {
        if (i == 0) {
            if (amount % coins[i] == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int use = 0;
        if (amount - coins[i] >= 0) {
            use = find(i, amount - coins[i], coins, dp);
        }
        int skip = find(i - 1, amount, coins, dp);

        return dp[i][amount] = use + skip;
    }

    public int change(int amount, int[] coins) {
        // int n = coins.length;
        // int dp[][] = new int[n][amount + 1];
        // for (int d[] : dp) {
        //     Arrays.fill(d, -1);
        // }
        // return find(n - 1, amount, coins, dp);

        // int n = coins.length;
        // int dp[][] = new int[n][amount + 1];
        // for (int amt = 0; amt <= amount; amt++) {
        //     dp[0][amt] = amt % coins[0] == 0 ? 1 : 0;
        // }
        // for (int i = 1; i < n; i++) {
        //     for (int amt = 0; amt <=amount; amt++) {
        //         int use = 0;
        //         if (amt - coins[i] >= 0) {
        //             use = dp[i][amt - coins[i]];
        //         }
        //         int skip = dp[i - 1][amt];

        //         dp[i][amt] = use + skip;
        //     }
        // }

        // return dp[n - 1][amount];


        // int n = coins.length;
        // // int dp[][] = new int[n][amount + 1];
        // int prev[] = new int[amount+1];
        // int curr[] = new int[amount+1];
        // for (int amt = 0; amt <= amount; amt++) {
        //     prev[amt] = amt % coins[0] == 0 ? 1 : 0;
        // }
        // for (int i = 1; i < n; i++) {
        //     for (int amt = 0; amt <=amount; amt++) {
        //         int use = 0;
        //         if (amt - coins[i] >= 0) {
        //             use = curr[amt - coins[i]];
        //         }
        //         int skip = prev[amt];

        //         curr[amt] = use + skip;
        //     }
        //     int t[] = prev;
        //     prev = curr;
        //     curr = t;
        // }

        // return prev[amount];


        int n = coins.length;
        // int dp[][] = new int[n][amount + 1];
        // int prev[] = new int[amount+1];
        int curr[] = new int[amount+1];
        for (int amt = 0; amt <= amount; amt++) {
            curr[amt] = amt % coins[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int amt = 0; amt <= amount; amt++) {
                int use = 0;
                int skip = curr[amt];
                if (amt - coins[i] >= 0) {
                    use = curr[amt - coins[i]];
                }

                curr[amt] = use + skip;
            }
        }

        return curr[amount];
    }
    /*
       Approach            TC                  SC

       Recursion           O(2^(N*amt))        O(N*amt) [recursion stack]
       Memoization         O(N*amt)            O(N*amt) [dp table] + O(N*amt) [recursion stack]
       Tabulation(2d)      O(N*amt)            O(N*amt) [2d dp array]
       Tabulation[2 arr]   O(N*amt)            O(2*amt) = O(amt) [prev + curr arrays]
       Tabulation(1 arr)   O(N*amt)            O(amt) [single curr array]
*/
}