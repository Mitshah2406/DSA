class Solution {
    public int find(int i, int prev, int nums[], int n, int dp[][]) {
        if (i == n) {
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        int take = 0;
        if (prev == -1 || (nums[prev] % nums[i] == 0 || nums[i] % nums[prev] == 0)) {
            take = 1 + find(i + 1, i, nums, n, dp);
        }
        int skip = 0 + find(i + 1, prev, nums, n, dp);

        return dp[i][prev + 1] = Math.max(take, skip);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Intuition - as subsets are asked, we can sort the array, and use longest increasing subsequence method, just we check the divisibility with prev
        // 1,4,7,8,16
        // 4%1==0 .. 8%4==0 .. eventually 4 is divisible to 1 so 8 is too.

        Arrays.sort(nums);
        int n = nums.length;
        // int dp[][] = new int[n][n+1];
        // for(int d[]:dp) Arrays.fill(d,-1);

        // int ans = find(0,-1,nums,n,dp);

        int dp[] = new int[n];
        int hash[] = new int[n];
        dp[0] = 1;
        hash[0] = 0;
        int ans = 0;
        int ansIdx = 0;
        for (int i = 1; i < n; i++) {
            int res = 1;
            hash[i] = i;
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0)) {
                    if (res < dp[j] + 1) {
                        res = dp[j] + 1;
                        hash[i] = j;
                    }
                }
            }
            dp[i] = res;
            if (ans < dp[i]) {
                ans = dp[i];
                ansIdx = i;
            }
        }
        int it = ansIdx;
        List<Integer> arr = new ArrayList();
        while (it != hash[it]) {
            int lastIdx = hash[it];
            arr.add(nums[it]);
            it = lastIdx;
        }
        arr.add(nums[it]);
        Collections.reverse(arr);
        return arr;
    }

    /*
        Sorting O(nlogn)
        DP O(n^2)
        Backtrack O(n)

        TC = O(nlogn) + O(n^2) + O(n) == O(n)
     */
}