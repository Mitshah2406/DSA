class Solution {
    public int memo(int i, int j, int k, String s1, String s2, String s3, int dp[][][]){
        if(i<0 || j<0 || k<0){
            return 0;
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        int take = 0;
        if(s1.charAt(i)==s2.charAt(j) && s2.charAt(j)==s3.charAt(k)){
            take = 1 + memo(i-1,j-1,k-1,s1,s2,s3,dp);
        }
        int skip =Math.max(memo(i,j-1,k,s1,s2,s3,dp), Math.max(memo(i,j,k-1,s1,s2,s3,dp),memo(i-1,j,k,s1,s2,s3,dp)));
    
        return dp[i][j][k] = Math.max(take,skip);
    }
    int lcsOf3(String s1, String s2, String s3) {
        // code here
        // int n = s1.length();
        // int m = s2.length();
        // int o = s3.length();
        // int dp[][][] = new int[n][m][o];
        // for(int d1[][]:dp){
        //     for(int d2[]:d1){
        //         Arrays.fill(d2,-1);
        //     }
        // }
        // return memo(n-1,m-1,o-1, s1,s2,s3,dp);
        
        
        // int n = s1.length();
        // int m = s2.length();
        // int o = s3.length();
        // int dp[][][] = new int[n+1][m+1][o+1];
        
        
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         for(int k=1;k<=o;k++){
        //             int take = 0;
        //             if(s1.charAt(i-1)==s2.charAt(j-1) && s2.charAt(j-1)==s3.charAt(k-1)){
        //                 take = 1 + dp[i-1][j-1][k-1];
        //             }
        //             int skip =Math.max(dp[i][j-1][k], Math.max(dp[i][j][k-1],dp[i-1][j][k]));
            
        //             dp[i][j][k] = Math.max(take,skip);
        //         }
        //     }
        // }
        
        // return dp[n][m][o];
        
        
        
        int n = s1.length();
        int m = s2.length();
        int o = s3.length();
        // int dp[][][] = new int[n+1][m+1][o+1];
        int curr[][] = new int[m+1][o+1];
        int prev[][] = new int[m+1][o+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=1;k<=o;k++){
                    int take = 0;
                    if(s1.charAt(i-1)==s2.charAt(j-1) && s2.charAt(j-1)==s3.charAt(k-1)){
                        take = 1 + prev[j-1][k-1];
                    }
                    int skip =Math.max(curr[j-1][k], Math.max(curr[j][k-1],prev[j][k]));
            
                    curr[j][k] = Math.max(take,skip);
                }
                // prev = curr.clone();
                }
            // for(int c=0;c<curr.length;c++){
            //     prev[c] = curr[c].clone();
            // }
            
            int[][] temp = prev;
            prev = curr;
            curr = temp;
// Clear curr for next iteration
        for(int j=0; j<=m; j++){
            Arrays.fill(curr[j], 0);
        }
        }
        
        return prev[m][o];
        
    }
    
    
// | Approach                 | Time Complexity | Space Complexity |
// | ------------------------ | --------------- | ---------------- |
// | Recursion (no memo)      | `O(3^N)`        | `O(N)` (stack)   |
// | Top-Down (Memoization)   | `O(n * m * o)`  | `O(n * m * o)`   |
// | Bottom-Up (3D DP)        | `O(n * m * o)`  | `O(n * m * o)`   |
// | Bottom-Up (2D Optimized) | `O(n * m * o)`  | `O(m * o)`       |

}
