class Solution {
    public int solve(int arr[], int n, int dp[][], int i, int prev) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        // rob
        int x = 0;
        if (prev == -1 || prev != i - 1) {
            int ans = solve(arr, n, dp, i + 2, i);
            x = arr[i] + ans;
        }
        // not rob
        int y = solve(arr, n, dp, i + 1, prev);

        return dp[i][prev + 1] = Math.max(x, y);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        int even = 0;
        int odd = 0;

        int dp[][] = new int[n + 1][n + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return solve(nums, n, dp, 0, -1);
    }
}