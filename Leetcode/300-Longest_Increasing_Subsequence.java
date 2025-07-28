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

        // int n = nums.length;
        // // int dp[][] = new int[n + 1][n + 1];
        // int ahead[] = new int[n+1];
        // int curr[] = new int[n+1];
        // // return find(0, -1, n, nums, dp);

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int prev = i - 1; prev >= -1; prev--) {
        //         int select = 0;
        //         if (prev == -1 || nums[prev] < nums[i]) {
        //             select = 1 + ahead[i + 1];
        //         }
        //         int reject = ahead[prev + 1];
        //         curr[prev + 1] = Math.max(select, reject);
        //     }
        //     ahead = curr;
        // }

        // return ahead[0];

        // O(n) space approach
        // int n = nums.length;
        // int dp[] = new int[n];
        // Arrays.fill(dp, 1);
        // int ans = 1;
        // for (int i = 1; i < n; i++) {
        //     int res = 1;
        //     for(int j=0;j<i;j++){
        //         if(nums[j]<nums[i]){
        //             res = Math.max(1+dp[j], res);
        //         }
        //     }
        //     dp[i] = res;
        //     ans = Math.max(ans, dp[i]);
        // }  
        // return ans; 


        // Binary Search Approach
        int n = nums.length;
        int dp[] = new int[n];
        int start = 0;
        int end = 1;
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>dp[end-1]){
                dp[end++] = nums[i];
                continue;
            }

            // perform bs

            int low = start;
            int high = end-1;
            int ans = -1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(dp[mid]==nums[i]){
                    ans = mid;
                    break;
                }else if(dp[mid]>nums[i]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            if(ans==-1){
                ans = low;
            }

            dp[ans] = nums[i];
        }

        return end;
    }
}
