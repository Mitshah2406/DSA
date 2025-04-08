class Solution {
    /*
        TC => O(1root(n)) * N = O(Nroot(N))
        SC => O(N)
    */
    public int count(int n, int dp[]) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, 1 + count(n - i * i, dp));
        }

        return dp[n] = res;
    }

    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return count(n, dp);
    }
}