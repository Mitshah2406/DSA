class Solution {
    public int find(int i, int j, String text1, String text2, int dp[][]) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = Math.max(ans, 1 + find(i - 1, j - 1, text1, text2, dp));
        }
        ans = Math.max(ans, find(i, j - 1, text1, text2, dp));
        ans = Math.max(ans, find(i - 1, j, text1, text2, dp));

        return dp[i][j] = ans;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // int n = text1.length();
        // int m = text2.length();
        // int dp[][] = new int[n][m];
        // for (int d[] : dp)
        //     Arrays.fill(d, -1);
        // return find(n - 1, m - 1, text1, text2, dp);

        // int n = text1.length();
        // int m = text2.length();
        // int dp[][] = new int[n+1][m+1];

        // // 1. base cases
        // // already satisfied

        // // 2. changing vars in reverse order
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= m; j++) {
        //         if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
        //             dp[i][j] = 1 + dp[i - 1][j - 1];  // characters match
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // no match
        //         }
        //     }
        // }

        // // 4. return same vars as recursive call
        // // return find(n - 1, m - 1, text1, text2, dp);
        // return dp[n][m];

        int n = text1.length();
        int m = text2.length();
        // int dp[][] = new int[n+1][m+1];

        // rolling arrs
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        // 1. base cases
        // already satisfied

        // 2. changing vars in reverse order
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1]; // characters match
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]); // no match
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        // 4. return same vars as recursive call
        // return find(n - 1, m - 1, text1, text2, dp);
        return prev[m];

    }
}
/* 
Version	                        Time Complexity	    Space Complexity
----------------------------------------------------------------------
Recursive (plain)	            Exponential	        O(1)
Recursive + Memoization 	    O(n * m)	        O(n * m)
Tabulation (2D array)	        O(n * m)	        O(n * m)
Space-optimized DP	            O(n * m)	        O(m)
*/
// 1,0 - not match
// 0,1 - not match
// 1,1 - both match