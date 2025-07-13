class Solution {
    public boolean check(int i, int n, int nums[], Boolean dp[]){
        if(i>=n){
            return false;
        }
        if(i==n-1) return true;
        if(dp[i]!=null) return dp[i];
        boolean ans = false;
        int maxJump = nums[i];
        for(int j=maxJump;j>=1;j--){
            ans = check(i+j, n, nums, dp);
            if(ans) break;
        }

        return dp[i] = ans;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return check(0, n, nums, dp);
    }
}