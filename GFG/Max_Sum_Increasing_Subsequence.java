// User function Template for Java

class Solution {
    public int find(int i, int prev,int n, int arr[], int dp[][]){
        if(i==n){
            return 0;
        }
        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }
        if(prev==-1 || arr[prev]<arr[i]){
            dp[i][prev+1] = arr[i] + find(i+1,i,n,arr,dp);
        }
        return dp[i][prev+1] = Math.max(dp[i][prev+1], find(i+1, prev,n, arr,dp));
    }
    public int maxSumIS(int arr[]) {
        // int n = arr.length;
        // int dp[][] = new int[n][n+1];
        // for(int d[]: dp){
        //     Arrays.fill(d,-1);
        // }
        // return find(0,-1,n, arr,dp);
        
        
        // int n = arr.length;
        // int dp[][] = new int[n + 1][n + 1];

        // // return find(0, -1, n, nums, dp);

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int prev = - 1; prev < n; prev++) {
        //         int select = 0;
        //         if (prev == -1 || arr[prev] < arr[i]) {
        //             select = arr[i] + dp[i + 1][i+1]; // here i+1 coz we do prev+1
        //         }
        //         int reject = dp[i + 1][prev + 1];
        //         dp[i][prev + 1] = Math.max(select, reject);
        //     }
        // }

        // return dp[0][0];
        
              
        // int n = arr.length;
        // int curr[] = new int[n + 1];
        // int ahead[] = new int[n + 1];
        // // return find(0, -1, n, nums, dp);

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int prev = - 1; prev < n; prev++) {
        //         int select = 0;
        //         if (prev == -1 || arr[prev] < arr[i]) {
        //             select = arr[i] + ahead[i+1]; // here i+1 coz we do prev+1
        //         }
        //         int reject = ahead[prev + 1];
        //         curr[prev + 1] = Math.max(select, reject);
        //     }
        //     ahead = curr;
        // }

        // return curr[0];
        
        
        int n = arr.length;
        // return find(0, -1, n, nums, dp);
        int dp[] = new int[n+1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i]) {
                    dp[i] = Math.max(dp[i], arr[i] + dp[prev]); // here i+1 coz we do prev+1
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;

    }
}
