import java.util.*;
public class Solution {
    public static int lcs(int i, int j, StringBuilder sb1, StringBuilder sb2, int dp[][]){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(sb1.charAt(i)==sb2.charAt(j)){
            return dp[i][j] = 1 + lcs(i-1,j-1,sb1,sb2,dp);
        }else{
            return dp[i][j] = Math.max(lcs(i-1,j,sb1,sb2,dp), lcs(i,j-1,sb1,sb2,dp));
        }
    }
    public static int minInsertion(String str) {
        // int n = str.length();
        // StringBuilder s1 = new StringBuilder(str);
        // StringBuilder s2 = new StringBuilder(str).reverse();
        // int dp[][] = new int[n][n];
        // for(int d[]: dp){
        //     Arrays.fill(d,-1);
        // }
        // int ans = lcs(n-1,n-1,s1,s2,dp);
        // return n - ans;


        // int n = str.length();
        // StringBuilder s2 = new StringBuilder(str).reverse();
        // int dp[][] = new int[n+1][n+1];
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n;j++){
        //         if(str.charAt(i-1)==s2.charAt(j-1)){
        //             dp[i][j] = 1 + dp[i-1][j-1];
        //         }else{
        //             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     }
        // }
        // int ans = dp[n][n];
        // return n - ans;


         int n = str.length();
        StringBuilder s2 = new StringBuilder(str).reverse();
        // int dp[][] = new int[n+1][n+1];
        int curr[] = new int[n+1];
        int prev[] = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(str.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            int t[] = prev;
            prev = curr;
            curr = t;
        }
        int ans = prev[n];
        return n - ans;
    }

    /*
    | Version                 | Time Complexity | Space Complexity |
    | ----------------------- | --------------- | ---------------- |
    | Only Recursion          | O(2^n)           | O(n)             |
    | Recursion + Memoization | O(n^2)           | O(n^2)            |
    | Tabulation (2D DP)      | O(n^2)           | O(n^2)            |
    | Space-Optimized DP      | O(n^2)           | O(n)             |

    */
}
