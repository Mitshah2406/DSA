class Solution {
    /*
     Backtracking approach
     Intuition:
     - For each element, we either include it in the subset or exclude it.
     - Recursively explore all possibilities.
     - If we reach the end and sum == 0, that is one valid subset.

     Time Complexity: O(2^n)
     Space Complexity: O(n) recursion stack
    */
    private int backtracking(int i, int sum, int arr[], int n){
        if(i==n){
            if(sum==0){
                return 1;
            }
            return 0;
        }
        
        int inc = backtracking(i+1, sum-arr[i], arr, n);
        int exc = backtracking(i+1, sum, arr, n);
        
        return inc+exc;
    }
    
    /*
     Memoization (Top-Down DP)
     Intuition:
     - Backtracking recomputes the same subproblems multiple times.
     - Store results in dp[i][sum] to avoid recomputation.
     - dp[i][sum] means number of ways to make "sum" starting from index i.

     Time Complexity: O(n * target)
     Space Complexity: O(n * target) + recursion stack
    */
    private int memo(int i, int sum, int arr[], int n, int dp[][]){
        if(i==n){
            if(sum==0){
                return 1;
            }
            return 0;
        }
        if(sum<0) return 0;
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        
        int inc = memo(i+1, sum-arr[i], arr, n, dp);
        int exc = memo(i+1, sum, arr, n, dp);
        
        return dp[i][sum] = inc+exc;
    }
    
    /*
     Tabulation (Bottom-Up DP)
     Steps to convert from memoization to tabulation:
     
     1. Base case
        - In memo, base case is: if (i == n) return (sum == 0 ? 1 : 0).
        - So in table: dp[n][0] = 1, and dp[n][sum > 0] = 0.
     
     2. Changing variables (reverse them)
        - Memo goes forward (i from 0→n).
        - Tabulation must go backward (i from n-1→0), because dp[i] depends on dp[i+1].
        - Similarly, sum goes from 0→target.
     
     3. Copy the recurrences
        - Memo recurrence: dp[i][sum] = dp[i+1][sum] + dp[i+1][sum-arr[i]] (if valid).
        - Copy the same into loops.

     Time Complexity: O(n * target)
     Space Complexity: O(n * target), can be optimized to O(target)
    */
    private int tabulation(int nums[], int target, int n){
        int dp[][] = new int[n+1][target+1];
        
        // base case
        dp[n][0] = 1;
        
        // fill table in reverse order of i
        for(int i=n-1;i>=0;i--){
            for(int sum=0;sum<=target;sum++){
                int inc = sum-nums[i]>=0 ? dp[i+1][sum-nums[i]] : 0;
                int exc = dp[i+1][sum];
        
                dp[i][sum] = inc+exc;
            }
        }
        
        return dp[0][target];
    }
    
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        
        // return backtracking(0,target, nums, n);
        
        // int dp[][] = new int[n][target+1];
        // for(int d[]:dp){
        //     Arrays.fill(d,-1);
        // }
        // return memo(0, target, nums, n, dp);
        
        return tabulation(nums,target,n);
    }
}
