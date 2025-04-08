class Solution {
    /*
        TC = N * O(2) = O(2N) as we make calls only once for each element due to memoization
        SC = O(N) + O(N) ~ O(2N)


        WITHOUT DP

        TC = O(2^N) (COZ TWO CALLS FOR EVERY ELEMENT)
        SC = O(N)

    */
    public int countWays(int currStep, int targetStep, int dp[]) {
        if (currStep == targetStep) {
            return 1;
        } else if (currStep > targetStep) {
            return 0;
        }
        if(dp[currStep]!=-1){
            return dp[currStep];
        }
        int way1 = countWays(currStep + 1, targetStep, dp);
        int way2 = countWays(currStep + 2, targetStep, dp);

        return dp[currStep] = way1 + way2;
    }

    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return countWays(0, n, dp);
    }
}