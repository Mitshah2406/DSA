class Solution {
    public int find(int i, int j, int alice, int piles[], int dp[][][]) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][alice] != -1) {
            return dp[i][j][alice];
        }
        int ans = 0;

        int takeFA = find(i + 1, j, 1, piles, dp) + piles[i];
        int takeBB = find(i, j - 1, 0, piles, dp) + piles[j];
        int takeBA = find(i, j - 1, 1, piles, dp) + piles[j];
        int takeFB = find(i + 1, j, 0, piles, dp) + piles[i];

        if (alice == 1) {
            return dp[i][j][alice] = Math.max(takeFA, takeBA);
        } else {
            return dp[i][j][alice] = Math.max(takeFB, takeBB);
        }
    }

    public boolean stoneGame(int[] piles) {
        // int n = piles.length;
        // int dp[][][] = new int[n][n][2];
        // for(int d1[][]:dp){
        //     for(int d2[]: d1){
        //         Arrays.fill(d2,-1);
        //     }
        // }
        // int ans = find(0, n - 1, 1, piles, dp);
        // // System.out.println(ans[0] + " " + ans[1]);
        // int sum = 0;
        // for(int p : piles) sum+=p;
        // return ans>(sum/2);

        int n = piles.length;
        int dp[][][] = new int[n+1][n][2];
        int sum = 0;
        for (int p : piles)
            sum += p;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n - 1; j++) {
                for (int alice = 0; alice <= 1; alice++) {
                    int ans = 0;

                    int takeFA = dp[i + 1][j][1] + piles[i];
                    int takeBB = dp[i][j - 1][0] + piles[j];
                    int takeBA = dp[i][j - 1][1] + piles[j];
                    int takeFB = dp[i + 1][j][0] + piles[i];

                    if (alice == 1) {
                        dp[i][j][alice] = Math.max(takeFA, takeBA);
                    } else {
                        dp[i][j][alice] = Math.max(takeFB, takeBB);
                    }
                }
            }
        }
        return dp[0][n-1][1] > (sum/2);
    }
}