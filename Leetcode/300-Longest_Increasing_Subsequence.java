class Solution {
    public int find(int i, int prev, int n, int nums[], int dp[][]) {
        if (i == n) {
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        int select = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            select = 1 + find(i + 1, i, n, nums, dp);
        }
        int reject = find(i + 1, prev, n, nums, dp);

        return dp[i][prev + 1] = Math.max(select, reject);
    }

    public int lengthOfLIS(int[] nums) {
        // int n = nums.length;
        // int dp[][] = new int[n][n + 1];
        // for (int d[] : dp)
        //     Arrays.fill(d, -1);
        // return find(0, -1, n, nums, dp);

        // // tabulation

        // int n = nums.length;
        // int dp[][] = new int[n + 1][n + 1];

        // // return find(0, -1, n, nums, dp);

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int prev = i - 1; prev >= -1; prev--) {
        //         int select = 0;
        //         if (prev == -1 || nums[prev] < nums[i]) {
        //             select = 1 + dp[i + 1][i + 1];
        //         }
        //         int reject = dp[i + 1][prev + 1];
        //         dp[i][prev + 1] = Math.max(select, reject);
        //     }
        // }

        // return dp[0][0];


         // tabulation - space

        int n = nums.length;
        // int dp[][] = new int[n + 1][n + 1];
        int ahead[] = new int[n+1];
        int curr[] = new int[n+1];
        // return find(0, -1, n, nums, dp);

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int select = 0;
                if (prev == -1 || nums[prev] < nums[i]) {
                    select = 1 + ahead[i + 1];
                }
                int reject = ahead[prev + 1];
                curr[prev + 1] = Math.max(select, reject);
            }
            ahead = curr;
        }

        return ahead[0];
    }
}
