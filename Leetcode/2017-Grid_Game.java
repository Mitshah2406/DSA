class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long pre[] = new long[n];
        long suff[] = new long[n];
        pre[0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + grid[0][i];
        }

        suff[n - 1] = grid[1][n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + grid[1][i];
        }

        long minSecondPlayerScore = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // Calculate sum for player 2 if player 1 chooses i
            long topRightSum = pre[n - 1] - pre[i];

            // Calculate sum for player 2 if player 1 chooses i
            long bottomLeftSum = (i > 0) ? suff[0] - suff[i] : 0;

            // Maximum score Player 2 can achieve for this column (observation) iska max
            long maxScore = Math.max(topRightSum, bottomLeftSum);

            // Minimize the maximum score for Player 2 but overall min
            // Track the minimum value of maxScore for all columns i. This gives the best column for Player 1.
            minSecondPlayerScore = Math.min(minSecondPlayerScore, maxScore);
        }

        return minSecondPlayerScore;
    }
}