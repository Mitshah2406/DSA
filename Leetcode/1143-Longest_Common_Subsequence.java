class Solution {
    private static int dp[][];

    private int lcs(char[] s1, int i, char[] s2, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (s1[i] == s2[j]) {
            ans = 1 + lcs(s1, i - 1, s2, j - 1);
        } else {
            int x = lcs(s1, i - 1, s2, j);
            int y = lcs(s1, i, s2, j - 1);
            ans = Math.max(x, y);
        }

        return dp[i][j] = ans;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char s1[] = text1.toCharArray();
        char s2[] = text2.toCharArray();
        int n = s1.length;
        int m = s2.length;
        dp = new int[n+1][m+1];
        // for (int d[] : dp) {
        //     Arrays.fill(d, -1);
        // }
        // return lcs(s1, n - 1, s2, m - 1);


        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}