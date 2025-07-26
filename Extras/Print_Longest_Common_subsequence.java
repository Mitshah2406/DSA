import java.util.*;

public class Solution {

    public static int memo(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + memo(i - 1, j - 1, s1, s2, dp);
        } else {
            dp[i][j] = Math.max(
                memo(i - 1, j, s1, s2, dp),
                memo(i, j - 1, s1, s2, dp)
            );
        }
        return dp[i][j];
    }

    public static String findLCS(int n, int m, String s1, String s2) {
        // int[][] dp = new int[n][m];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        // memo(n - 1, m - 1, s1, s2, dp);
        // StringBuilder sb = new StringBuilder();
        // int i = n - 1, j = m - 1;

        // while (i >= 0 && j >= 0) {
        //     if (s1.charAt(i) == s2.charAt(j)) {
        //         sb.append(s1.charAt(i));
        //         i--;
        //         j--;
        //     } else if (i > 0 && (j == 0 || dp[i - 1][j] >= dp[i][j - 1])) {
        //         i--;
        //     } else {
        //         j--;
        //     }
        // }

        // return sb.reverse().toString();


        int[][] dp = new int[n+1][m+1];
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }
        int i = n, j = m;

        while (i >= 1 && j >= 1) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();


        // Approach	            Time Complexity	Space Complexity	Can Build LCS?
        // Recursion Only	        O(2^(n + m))	O(n + m)	        Yes
        // Recursion + Memo	    O(n * m)	    O(n * m)	        Yes
        // Tabulation	            O(n * m)	    O(n * m)	        Yes
        // Space Optimized (Len)	O(n * m)	    O(m)	            No (only length)
    }
}
