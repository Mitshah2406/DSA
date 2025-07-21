class Solution {
    public int find(int i, int arr[], int dp[]){
        if(i < 0){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
    
        
        int loot = arr[i] + find(i - 2, arr, dp);
    
        int skip = find(i - 1, arr, dp);
    
        return dp[i] = Math.max(loot, skip);
    }

    public int findMaxSum(int arr[]) {
        // code here
    //   int n = arr.length;
    //   int dp[] = new int[n];
    //   Arrays.fill(dp,-1);
    //   return find(n-1, arr,dp);
    
    // Tabulation
        // int n = arr.length;
        // if (n == 0) return 0;
        // if (n == 1) return arr[0];
    
        // int[] dp = new int[n];
        // dp[0] = arr[0];
        // dp[1] = Math.max(arr[0], arr[1]);
    
        // for (int i = 2; i < n; i++) {
        //     int loot = arr[i] + dp[i - 2];
        //     int skip = dp[i - 1];
        //     dp[i] = Math.max(loot, skip);
        // }
    
        // return dp[n - 1];
        
        
        // SPACE
        int n = arr.length;
        if (n == 0) return 0;

        int dpM1 = arr[0];
        int dpM2 = 0;
        for (int i = 1; i < n; i++) {
            int loot = (i-2)>=0 ? arr[i] + dpM2 : arr[i];
            int skip = dpM1;
            int ans = Math.max(loot, skip);
            dpM2 = dpM1;
            dpM1 = ans;
            
        }
    
        return dpM1;
    }
}
