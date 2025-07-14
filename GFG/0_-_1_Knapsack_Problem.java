class Solution {
    public static int find(int i, int w, int val[], int wt[], int n, int dp[][]){
        if(i==n || w==0){
            return 0;
        }
        if(dp[i][w]!=-1){
            return dp[i][w];
        }
        int inc = 0;
        if(wt[i]<=w){
            inc = val[i] + find(i+1,w-wt[i],val,wt,n,dp);
        }
        int exc = find(i+1,w,val,wt,n,dp);
        
        return dp[i][w] = Math.max(inc,exc);
    }
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        // int n = val.length;
        // int dp[][] = new int[n][W+1];
        // for(int d[]: dp) Arrays.fill(d,-1);
        // return find(0,W,val,wt,n,dp);
        
        
        // // Tabulation
        
        // // 1. Write base cases
        // int n = val.length;
        // int dp[][] = new int[n+1][W+1];
        // // dp[n] = 0, dp[i][0] = 0;
        
        // // 2. Identify changing vars, write in rev order [i,w]
        // for(int i=n-1;i>=0;i--){
        //     for(int w=0;w<=W;w++){
        //         // 3. Copy the recurrences
        //         int inc = 0;
        //         if(wt[i]<=w){
        //             inc = val[i] + dp[i+1][w-wt[i]];
        //         }
        //         int exc = dp[i+1][w];
        
        //         dp[i][w] = Math.max(inc,exc);
        //     }
        // }
        
        // return dp[0][W];
        
        
        // Tabulation - Space Optimized
        
        // // 1. Write base cases
        // int n = val.length;
        // // int dp[][] = new int[n+1][W+1];
        // // dp[n] = 0, dp[i][0] = 0;
        // int ahead[] = new int[W+1];
        // int curr[] = new int[W+1];
        // // 2. Identify changing vars, write in rev order [i,w]
        // for(int i=n-1;i>=0;i--){
        //     for(int w=W;w>=0;w--){ // any way works coz it depends on prev(ahead) row
        //         // 3. Copy the recurrences
        //         int inc = 0;
        //         if(wt[i]<=w){
        //             inc = val[i] + ahead[w-wt[i]];
        //         }
        //         int exc = ahead[w];
        
        //         curr[w] = Math.max(inc,exc);
        //     }
        //     int t[] = curr;
        //     curr = ahead;
        //     ahead = t;
        // }
        
        // return ahead[W];
        
        
         // Tabulation - Space Optimized - 1
         // 1. Write base cases
        int n = val.length;
        // int dp[][] = new int[n+1][W+1];
        // dp[n] = 0, dp[i][0] = 0;
        int ahead[] = new int[W+1];
        // int curr[] = new int[W+1];
        // 2. Identify changing vars, write in rev order [i,w]
        for(int i=n-1;i>=0;i--){
            for(int w=W;w>=0;w--){ // any way works coz it depends on prev(ahead) row
                // 3. Copy the recurrences
                int inc = 0;
                if(wt[i]<=w){
                    inc = val[i] + ahead[w-wt[i]];
                }
                int exc = ahead[w];
        
                ahead[w] = Math.max(inc,exc);
            }
        }
        
        return ahead[W];
    }
}
