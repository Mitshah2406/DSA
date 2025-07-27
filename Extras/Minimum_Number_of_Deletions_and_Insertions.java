import java.util.*;
public class Solution {
    public static int lcs(int i, int j, String s1, String s2, int dp[][]){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1 + lcs(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j] = Math.max(lcs(i-1,j,s1,s2,dp), lcs(i,j-1,s1,s2,dp));
    }
    public static int canYouMake(String s1, String s2) {
        // int n = s1.length();
        // int m = s2.length();
        // int dp[][] = new int[n][m];
        // for(int d[]: dp){
        //     Arrays.fill(d,-1);
        // }
        // int ans = lcs(n-1,m-1, s1,s2,dp);
        // return (n-ans)+(m-ans);



        // int n = s1.length();
        // int m = s2.length();
        // int dp[][] = new int[n+1][m+1];
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(s1.charAt(i-1)==s2.charAt(j-1)){
        //             dp[i][j] = 1 + dp[i-1][j-1];
        //         }else{
        //             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     }
        // }
        // int ans = dp[n][m];
        // return (n-ans)+(m-ans);



        int n = s1.length();
        int m = s2.length();
        // int dp[][] = new int[n+1][m+1];
        int curr[] = new int[m+1];
        int prev[] = new int[m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            int tp[] = prev;
            prev = curr;
            curr = tp;
        }
        int ans = prev[m];
        return (n-ans)+(m-ans);
    }
    /*
    | Approach                   | Time Complexity | Space Complexity    |
    | -------------------------- | --------------- | ------------------- |
    | Pure Recursion             | O(2^(n + m))    | O(n + m) (stack)    |
    | Recursion + Memoization    | O(n ? m)        | O(n ? m) + O(n + m) |
    | Tabulation (Bottom-Up)     | O(n ? m)        | O(n ? m)            |
    | Space Optimized Tabulation | O(n ? m)        | O(m)                |

    */
}

// DO LCS, then s1LEN - LCS + s2Len - LCS

// edl
// xcqja

// lcs = 0;

// 3-0+5-0 = 8
