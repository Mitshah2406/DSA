// Medium

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

 

// Example 1:


// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1
 

// Constraints:

// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104


//Link --> https://leetcode.com/problems/container-with-most-water/description/
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (i < j) {
            int width = (j - i);
            int ht = Math.min(height[i], height[j]);
            int waterStored = width * ht;

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            ans = Math.max(ans, waterStored);
        }
        return ans;
    }
}

// TC - O(n);
// SC = O(1);