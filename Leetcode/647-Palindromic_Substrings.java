class Solution {

    // Helper: Expand Around Center method to count palindromes from indices i and j
    private int countPalindromes(String s, int i, int j, int n) {
        int res = 0;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            res++;
        }
        return res;
    }

    // Helper: Recursive + Memoization check for palindrome
    private boolean isPalindrome(int i, int j, String s, int n, Boolean dp[][]) {
        if (i >= j) // Single char or empty string
            return true;
        if (dp[i][j] != null) // Already computed
            return dp[i][j];

        if (s.charAt(i) != s.charAt(j)) // Mismatch means not palindrome
            return dp[i][j] = false;

        if (j - i < 2) // Adjacent equal chars or single char
            return dp[i][j] = true;

        return dp[i][j] = isPalindrome(i + 1, j - 1, s, n, dp);
    }

    public int countSubstrings(String s) {

        /*
        =========================
        APPROACH 1: Expand Around Center (Two Pointers)
        =========================
        Intuition:
            - Every palindrome can be expanded from its center.
            - There are 2n - 1 possible centers (n odd centers, n-1 even centers).
            - For each center, expand outward while chars match.
        Time Complexity:
            - O(n^2) because for each center we can expand up to O(n) in the worst case.
        Space Complexity:
            - O(1) as we only use a few pointers.
        */
        // int n = s.length();
        // int res = 0;
        // for (int i = 0; i < n; i++) {
        //     res += countPalindromes(s, i, i, n);     // Odd-length palindromes
        //     res += countPalindromes(s, i, i + 1, n); // Even-length palindromes
        // }
        // return res;


        /*
        =========================
        APPROACH 2: Recursive + Memoization
        =========================
        Intuition:
            - Recursively check if substring s[i...j] is a palindrome.
            - Store results in dp[i][j] to avoid recomputation.
        Time Complexity:
            - O(n^2) because there are n^2 states (i, j).
        Space Complexity:
            - O(n^2) for dp + O(n) recursion stack.
        */
        // int res = 0;
        // int n = s.length();
        // Boolean dp[][] = new Boolean[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         if (isPalindrome(i, j, s, n, dp))
        //             res++;
        //     }
        // }
        // return res;


        /*
        =========================
        APPROACH 3: Bottom-Up DP (Full 2D Table)
        =========================
        Intuition:
            - dp[i][j] = true if s[i...j] is palindrome.
            - Fill table from shorter substrings to longer.
        Time Complexity:
            - O(n^2) to fill the table.
        Space Complexity:
            - O(n^2) for dp table.
        */
        // int res = 0;
        // int n = s.length();
        // Boolean dp[][] = new Boolean[n + 1][n + 1];
        // for (int i = n - 1; i >= 0; i--) {
        //     for (int j = n - 1; j >= i; j--) {
        //         if (i >= j) {
        //             dp[i][j] = true;
        //         } else if (s.charAt(i) != s.charAt(j)) {
        //             dp[i][j] = false;
        //         } else if (j - i < 2) {
        //             dp[i][j] = true;
        //         } else {
        //             dp[i][j] = j > 0 ? dp[i + 1][j - 1] : null;
        //         }
        //         res += (dp[i][j] != null && dp[i][j]) ? 1 : 0;
        //     }
        // }
        // return res;


        /*
        =========================
        APPROACH 4: Bottom-Up DP with Space Optimization
        =========================
        Intuition:
            - Instead of full dp[][], we only need dp[i+1][j-1] from the previous row.
            - Use two 1D arrays (ahead and curr) to store results for current and next iteration.
        Time Complexity:
            - O(n^2)
        Space Complexity:
            - O(n) due to two arrays instead of full table.
        */
        int res = 0;
        int n = s.length();
        Boolean ahead[] = new Boolean[n + 1];
        Boolean curr[] = new Boolean[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (i >= j) {
                    curr[j] = true;
                } else if (s.charAt(i) != s.charAt(j)) {
                    curr[j] = false;
                } else if (j - i < 2) {
                    curr[j] = true;
                } else {
                    curr[j] = j > 0 ? ahead[j - 1] : null;
                }
                res += (curr[j] != null && curr[j]) ? 1 : 0;
            }
            ahead = curr.clone(); // Move current row to ahead for next iteration
        }
        return res;
    }
}
