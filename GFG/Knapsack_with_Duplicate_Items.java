//User function Template for Java

class Solution{
    private static int dp[][];
    private static int memo(int wt[], int profit[], int W, int i){
        if(i==-1 || W<=0){
            return 0;
        }
        
        if(dp[i][W]!=-1){
            return dp[i][W];
        }
        
        int exc = memo(wt, profit, W, i-1);
        int inc = 0;
        if(W>=wt[i]){
            inc = memo(wt, profit, W-wt[i], i) + profit[i];
        }
        
        return dp[i][W] = Math.max(exc,inc);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        dp = new int[N][W+1];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        return memo(wt, val, W,N-1);
    }
}