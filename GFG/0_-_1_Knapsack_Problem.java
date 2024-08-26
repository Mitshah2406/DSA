class Solution {
    private static int dp[][];
    private static int memo(int wt[], int profit[], int W, int i){
        if(i==-1 || W==0){
            return 0;
        }
        if(dp[i][W]!=-1){
            return dp[i][W];
        }
        int exc = memo(wt, profit, W, i-1);
        int inc = 0;
        if(W>=wt[i]){
            inc = memo(wt, profit, W-wt[i], i-1) + profit[i];
        }
        
        return dp[i][W]=Math.max(exc,inc);
    }
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        dp = new int[wt.length][W+1];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        return memo(wt,val, W, wt.length-1);
    }
}
