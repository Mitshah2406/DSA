class Solution {
    private int dp[][];

    private int solve(char s1[], int i, char[] s2, int j) {
        if (i == -1 && j == -1) {
            return 0;
        }
        if (i == -1 && j != -1) {
            return j + 1;
        }
        if (i != -1 && j == -1) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1[i] == s2[j]) {
            dp[i][j] = solve(s1, i - 1, s2, j - 1);
        } else {
            // add
            int x = solve(s1, i, s2, j - 1);
            // replace
            int y = solve(s1, i - 1, s2, j - 1);
            // delete
            int z = solve(s1, i - 1, s2, j);

            dp[i][j] = Math.min(Math.min(x, y), z) + 1;
        }

        return dp[i][j];
    }

    public int minDistance(String word1, String word2) {
        char s1[] = word1.toCharArray();
        char s2[] = word2.toCharArray();
        int n = s1.length;
        int m = s2.length;

        // Memoization
        // dp = new int[n][m];
        // for(int d[]: dp){
        // Arrays.fill(d,-1);
        // }
        // return solve(s1,n-1,s2,m-1);

        // Iterative
        dp = new int[n + 1][m + 1];
        // Initialize the base cases
        // if dono eksaath empty hue to i-1,j-1 hoga that means 0
        // but if koi ek pehle empty hua toh utne replacements ya deletions ke liye doing this
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i; // If s2 is empty, we need i deletions to match
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j; // If s1 is empty, we need j insertions to match
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // add
                    int x = dp[i][j - 1];
                    // replace
                    int y = dp[i - 1][j - 1];
                    // del
                    int z = dp[i - 1][j];

                    dp[i][j] = Math.min(Math.min(x, y), z) + 1;
                }
            }
        }

        return dp[n][m];

    }
}