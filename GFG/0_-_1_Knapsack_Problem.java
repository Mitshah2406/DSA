class Solution {
    /*
    TC => O(N*W) {Due to avoiding recomputation using memoization
    SC => O(N*W) + O(N) {DP Arr Space + Auxillary Stack Space
    */
    public static int calc(int W,int n, int profit[], int wt[], int i, int currW, int dp[][]){
        if(i==n || currW>=W){
            return 0;
        }
        if(dp[i][currW]!=-1){
            return dp[i][currW];
        }
        int select = 0;
        if(currW+wt[i]<=W){
            select = profit[i] + calc(W,n,profit, wt, i+1, currW+wt[i], dp);
        }
        int reject = calc(W,n,profit, wt, i+1, currW, dp);
        
        
        return dp[i][currW] = Math.max(select, reject);
    }
    static int knapsack(int W, int val[], int wt[]) {
        // code here
       int n = val.length;
       int dp[][] = new int[n][W+1];
       for(int d[]: dp){
           Arrays.fill(d, -1);
       }
       return calc(W,n, val, wt, 0, 0, dp);
    }
}
