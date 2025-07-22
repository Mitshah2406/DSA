class Solution {
    public int find(int i, int j, int n, String s, int dp[][]) {
        if (i < 0 || j == n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 1 + find(i - 1, j + 1, n, s, dp);
        }
        return dp[i][j] = Math.max(find(i - 1, j, n, s, dp), find(i, j + 1, n, s, dp));
    }

    public int longestPalindromeSubseq(String s) {
        // int n = s.length();
        // int dp[][] = new int[n][n];
        // for(int d[]: dp){
        //     Arrays.fill(d,-1);
        // }
        // return find(n-1,0,n,s,dp);

        // int n = s.length();
        // int dp[][] = new int[n+1][n+1];
        // // return find(n - 1, 0, n, s, dp);
        // char arr[] = s.toCharArray();
        // for (int i = 1; i <= n; i++) {
        //     for (int j = n - 1; j >= 0; j--) {
        //         if (arr[i-1] == arr[j]) {
        //             dp[i][j] = 1 + dp[i - 1][j + 1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
        //         }
        //     }
        // }

        // return dp[n][0];


        int n = s.length();
        // int dp[][] = new int[n+1][n+1];
        int prev[] = new int[n+1];
        int curr[] = new int[n+1];
        // return find(n - 1, 0, n, s, dp);
        char arr[] = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i-1] == arr[j]) {
                    curr[j] = 1 + prev[j + 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j + 1]);
                }
            }
            prev = curr.clone();
        }

        return prev[0];


    }
}