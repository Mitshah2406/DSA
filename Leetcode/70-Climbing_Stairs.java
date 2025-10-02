class Solution {
    /**
    Time Complexity = 2^n
    Space = O(n)
     */
    private int countRecursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        int x = countRecursion(n - 1);
        int y = countRecursion(n - 2);

        return x + y;
    }

    /**
    Time Complexity = O(n)
    Space = O(n) + O(n)
     */
    private int countMemo(int n, int dp[]) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int x = countMemo(n - 1, dp);
        int y = countMemo(n - 2, dp);

        return dp[n] = x + y;
    }

    public int climbStairs(int n) {

        // return countRecursion(n);

        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // return countMemo(n,dp);

        /**
        Tabulation
        Time Complexity = O(n)
        Space = O(n) 
        */
        // int dp[] = new int[n + 1];
        // 1. Write Base Cases
        // 2. Changing Vars (In Reverse) [n]
        // 3. Copy Recurrences
        // dp[0] = 1;
        // for (int i = 1; i <= n; i++) {
        //     int x = dp[i - 1];
        //     int y = i - 2 < 0 ? 0 : dp[i - 2];
        //     dp[i] = x + y;
        // }
        // return dp[n];


        /**
        Tabulation - Space Optimized
        Time Complexity = O(n)
        Space = O(1) 
        */
        int prevM1 = 0;
        int prevM2 = 0;
        // 1. Write Base Cases
        // 2. Changing Vars (In Reverse) [n]
        // 3. Copy Recurrences
        prevM1 = 1;
        for (int i = 1; i <= n; i++) {
            int x = prevM1;
            int y = i - 2 < 0 ? 0 : prevM2;
            prevM2 = prevM1;
            prevM1 = x+y;
        }
        return prevM1;
    }
}