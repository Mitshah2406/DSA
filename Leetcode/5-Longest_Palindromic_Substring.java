class Solution {
    /*
    Complexity
    
    Time: O(n^2) because you check all (i, j) pairs, but each check is O(1) with memoization.
    
    Space: O(n^2) for the dp table
     */
    private boolean palindrome(int i, int j, int n, String s, Boolean dp[][]) {
        if (i >= j)
            return dp[i][j] = true;
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) != s.charAt(j))
            return dp[i][j] = false;

        if (j - i < 2)
            return dp[i][j] = true;

        return dp[i][j] = palindrome(i + 1, j - 1, n, s, dp);
    }
    public String longestPalindrome(String s) {
        // int n = s.length();
        // int res = 0;
        // int start=0, end=0;
        // Boolean dp[][] = new Boolean[n][n];

        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         if (res > (j - i + 1))
        //             continue;
        //         boolean isPalindrome = palindrome(i, j, n, s, dp);
        //         if (isPalindrome && res < (j - i + 1)) {
        //             res = (j - i + 1);
        //             start=i;
        //             end=j+1;
        //         }
        //     }
        // }
        // return s.substring(start,end);

        // int n = s.length();
        // int res = 0;
        // int start = 0, end = 0;
        // // 1. Base case
        // Boolean dp[][] = new Boolean[n + 1][n + 1];
        // // 2. changing variables
        // for (int i = n - 1; i >= 0; i--) {
        //     for (int j = n - 1; j >= i; j--) {
        //         if (i >= j) {
        //             dp[i][j] = true;
        //         } else if (s.charAt(i) != s.charAt(j)) {
        //             dp[i][j] = false;
        //         } else if (j - i < 2) {
        //             dp[i][j] = true;
        //         } else {
        //             dp[i][j] = j > 0 ? dp[i + 1][j - 1] : null;
        //         }

        //         if (dp[i][j] != null && dp[i][j] == true && res < (j - i + 1)) {
        //             res = (j - i + 1);
        //             start = i;
        //             end = j+1;
        //         }
        //     }
        // }
        // return s.substring(start,end);

        int n = s.length();
        int res = 0;
        int start = 0, end=0;
        // 1. Base case
        // Boolean dp[][] = new Boolean[n + 1][n + 1];
        Boolean ahead[] = new Boolean[n + 1];
        Boolean curr[] = new Boolean[n + 1];
        // 2. changing variables
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (i >= j) {
                    curr[j] = true;
                } else if (s.charAt(i) != s.charAt(j)) {
                    curr[j] = false;
                } else if (j - i < 2) {
                    curr[j] = true;
                } else {
                    curr[j] = j > 0 ? ahead[j - 1] : null;
                }

                if (curr[j] != null && curr[j] == true && res < (j - i + 1)) {
                    res = (j - i + 1);
                    start = i; end=j+1;
                }
            }
            ahead = curr.clone();
        }
        return s.substring(start,end);

    }
}