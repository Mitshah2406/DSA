class Solution {
    public boolean find(int arr[], int i, int n, int target, int sum, int dp[][]) {
        if (sum == target) {
            return true;
        }
        if (i == n || sum > target) {
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1 ? true : false;
        }
        boolean x = find(arr, i + 1, n, target, sum + arr[i], dp);
        boolean y = find(arr, i + 1, n, target, sum, dp);

        boolean ans = (x || y);
        dp[i][sum] = ans == true ? 1 : 0;
        return ans;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        
        for (int i : nums) {
            sum += i;
        }
        int dp[][] = new int[n][sum+1]; // -1 -> not assigned, 0->false, 1->true
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        if (sum % 2 == 1) {
            return false;
        }

        return find(nums, 0, n, sum / 2, 0, dp);
    }
}