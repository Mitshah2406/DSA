class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        int ways[] = new int[n];
        dp[0] = 1;
        ways[0] = 1;
        int max = 1;
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            ways[i] = 1;
            int res = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] == dp[j] + 1) {
                        ways[i] += ways[j];
                    } else if (dp[i] < dp[j] + 1) {
                        ways[i] = ways[j];
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                maxIdx = i;
            }
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                num += ways[i];
            }
        }

        return num;
    }
}