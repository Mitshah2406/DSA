class Solution {
    /**
    Intuition - Uncrossed Lines, subsequences will always be uncrossed, as we go ahead when there is match, or stay there if no match
    Memoization
    Time = O(n*m)
    Space = O(n*m) + O(n+m)

    Tabulation
    Time = O(n*m)
    Space = O(n*m)

    Tabulation(Space Optimized)
    Time = O(n*m)
    Space = O(m)
     */
    private int find(int i, int j, int nums1[], int nums2[], int dp[][]) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (nums1[i] == nums2[j]) {
            return dp[i][j] = ans = 1 + find(i - 1, j - 1, nums1, nums2, dp);
        }

        return dp[i][j] = Math.max(find(i - 1, j, nums1, nums2, dp), find(i, j - 1, nums1, nums2, dp));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // int n = nums1.length;
        // int m = nums2.length;
        // int dp[][] = new int[n][m];
        // for(int d[]: dp){
        //     Arrays.fill(d,-1);
        // }
        // return find(n-1, m-1, nums1, nums2, dp);

        // Tabulation
        // int n = nums1.length;
        // int m = nums2.length;
        // // 1. base case
        // int dp[][] = new int[n + 1][m + 1];

        // // 2. changing vars (reverse order)

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= m; j++) {
        //         // 3. copy recurrences
        //         int ans = 0;
        //         if (nums1[i - 1] == nums2[j - 1]) {
        //             dp[i][j] = ans = 1 + dp[i - 1][j - 1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }

        // return dp[n][m];

        // Tabulation With Space

        int n = nums1.length;
        int m = nums2.length;
        // 1. base case
        // int dp[][] = new int[n + 1][m + 1];
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        // 2. changing vars (reverse order)

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 3. copy recurrences
                int ans = 0;
                if (nums1[i - 1] == nums2[j - 1]) {
                    curr[j] = ans = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            int t[] = prev;
            prev = curr;
            curr = t;
        }

        return prev[m];
    }
}