/*
Same as MCM problem, but there is a slight change you cannot burst one balloon and multiply adjacent nbrs, as it may have dependency on the other partitions
eg = [3,1,5,8] burst 1[ans=15]
[3] [5,8] here bursting 3 or 5 will have an dependency on other partition

*** Instead, we go in reverse order of bursting, we burst the balloon which is to burst last 
and we derive the formula

arr[i-1] * arr[k] * arr[j+1]

Time Complexity = O(3^n) {Without DP}
Time Complexity = O(n^3) With DP

Space Complexity = O(n^2) + O(auxillary space)
 */

class Solution {
    public int find(int i, int j, int arr[], int dp[][]) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = (int) -1e9;
        for (int k = i; k <= j; k++) {
            int burstTreat = arr[i - 1] * arr[k] * arr[j + 1];
            int res = burstTreat + find(i, k - 1, arr, dp) + find(k + 1, j, arr, dp);
            ans = Math.max(res, ans);
        }
        return dp[i][j] = ans;
    }

    public int maxCoins(int[] nums) {
        // int arr[] = new int[nums.length + 2];
        // int n = arr.length;
        // arr[0] = arr[n - 1] = 1;
        // for (int i = 1; i < n - 1; i++) {
        //     arr[i] = nums[i - 1];
        // }
        // int dp[][] = new int[nums.length + 2][nums.length + 2];
        // for (int d[] : dp) {
        //     Arrays.fill(d, -1);
        // }
        // return find(1, nums.length, arr, dp);


        // tabulation
        int ogLen = nums.length;
        int arr[] = new int[ogLen + 2];
        int n = arr.length;
        arr[0] = arr[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            arr[i] = nums[i - 1];
        }
        int dp[][] = new int[ogLen + 2][ogLen + 2];
        // 1. base case

        // 2. changing vars 
        // i => 1 to n
        // j => ogLen to 1

        for(int i=ogLen;i>=1;i--){
            for(int j=1;j<=ogLen;j++){
                if(i>j) continue;
                int ans = (int) -1e9;
                for (int k = i; k <= j; k++) {
                    int burstTreat = arr[i - 1] * arr[k] * arr[j + 1];
                    int res = burstTreat + dp[i][k - 1] + dp[k + 1][j];
                    ans = Math.max(res, ans);
                }
                dp[i][j] = ans;
            }
        }

        return dp[1][ogLen];
    }
}
