// Hard

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

// Link --> https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int pref[] = new int[n];
        int suff[] = new int[n];
        prefixMax(height, n, pref);
        suffixMax(height, n, suff);
        for (int i = 1; i < n - 1; i++) {
            int yb = Math.min(pref[i - 1], suff[i + 1]);
            int amt = yb - height[i];
            if (amt > 0) {
                ans += amt;
            }
        }
        return ans;
    }

    public void prefixMax(int[] height, int n, int[] pref) {
        pref[0] = height[0];
        for (int i = 1; i < n; i++) {
            pref[i] = Math.max(pref[i - 1], height[i]);
        }
    }

    public void suffixMax(int[] height, int n, int[] suff) {
        suff[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = Math.max(suff[i + 1], height[i]);
        }
    }
}


// TC - O(N)
// SC - O(N)