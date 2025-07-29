class Solution {
    private int find(int i, int n, int arr[], int t, int dp[]) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = 0;
        int currMax = 0; // running max;
        for (int k = i; k < Math.min(n, i + t); k++) {
            currMax = Math.max(currMax, arr[k]);
            int cost = currMax * (k - i + 1);
            ans = Math.max(cost + find(k + 1, n, arr, t, dp), ans);
        }
        return dp[i] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        // int n = arr.length;
        // int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        // return find(0, n, arr, k, dp);

        int n = arr.length;
        int dp[] = new int[n + 1]; // for base case

        for (int i = n - 1; i >= 0; i--) {
            int ans = 0;
            int currMax = 0; // running max;
            for (int ki = i; ki < Math.min(n, i + k); ki++) {
                currMax = Math.max(currMax, arr[ki]);
                int cost = currMax * (ki - i + 1);
                ans = Math.max(cost + dp[ki + 1], ans);
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    /*
    Front partition dp - try all partitions upto k

    Time Complexity 

    Memoization => O(N) * O(k) = O(N^2) [Worst Case]
    Tabulation => O(N) * O(k) = O(N^2)

    Space Complexity 

    Memoization => O(N) + O(N) = O(2N)
    Tabulation => O(N)
    */
}