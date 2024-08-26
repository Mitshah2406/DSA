class Solution
{   
    // Inclusion Exclusion DP Problem
    private int dp[];
    private int maxSubsequenceSum(int arr[], int i){
        if(i<0){
            // 0 is better than any negative number
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int exc = maxSubsequenceSum(arr,i-1);
        int inc = maxSubsequenceSum(arr, i-2) + arr[i]; // minus 2 bcoz cant include consecutive elements
        
        return dp[i] = Math.max(exc, inc);
    }
    public int FindMaxSum(int arr[], int n)
    {
        dp = new int[n];
        Arrays.fill(dp,-1);
        return maxSubsequenceSum(arr, n-1);
    }
}