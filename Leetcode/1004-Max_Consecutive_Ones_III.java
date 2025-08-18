class Solution {
    public int longestOnes(int[] nums, int k) {
        /*
        Approach 1 (with while)
        
        Intuition:
        Use sliding window
        Expand right pointer and count zeroes
        If zeroes > k -> shrink from left using while
        Keeps window always valid
        Record maximum window length
        
        Example:
        nums = [1,1,0,0,1], k=1
        Expand until invalid, then shrink until valid, track max size
        
        Time complexity: O(2n) ~ O(n)
        Space complexity: O(1)
        */

        // int n = nums.length;
        // int zeroes = 0, left = 0, right = 0, ans = 0;
        // while (right < n) {
        //     if (nums[right] == 0) zeroes++;
        //     while (zeroes > k) {
        //         if (nums[left] == 0) zeroes--;
        //         left++;
        //     }
        //     ans = Math.max(ans, right - left + 1);
        //     right++;
        // }
        // return ans;

        /*
        Approach 2 (with if)
        
        Intuition:
        same as approach 1
         Instead of shrinking fully in one go (while), shrink only one step if invalid
         Window becomes valid in later iterations, so result is still correct
        
        Example:
        nums = [1,0,0,1], k=1
        
        right=0 -> [1], zeroes=0 -> ans=1
        right=1 -> [1,0], zeroes=1 -> ans=2
        right=2 -> [1,0,0], zeroes=2 (>k)
           if triggers -> drop nums[left=0]=1, left=1
           still zeroes=2, will be fixed in next step
        right=3 -> [0,0,1], zeroes=2 (>k)
           if triggers -> drop nums[left=1]=0, zeroes=1, left=2
           now valid, ans updated
        
        Time complexity: O(n)
        Space complexity: O(1)
        */

        int n = nums.length;
        int zeroes = 0, left = 0, right = 0, ans = 0;
        while (right < n) {
            if (nums[right] == 0)
                zeroes++;

            if (zeroes > k) {
                if (nums[left] == 0)
                    zeroes--;
                left++;
            }

            if (zeroes <= k) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans;
    }
}
