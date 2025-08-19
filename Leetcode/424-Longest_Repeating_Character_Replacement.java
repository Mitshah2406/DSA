class Solution {
    public int characterReplacement(String s, int k) {
        /*
        Approach 1: Brute force
        Intuition: For every starting index, try to extend the substring and keep track of character counts.
        Check if we can make it valid with at most k replacements. Update the answer if possible, otherwise break.
        Time complexity: O(n^2) because we check all substrings.
        Space complexity: O(1) since at most 26 characters.
        */

        // int n = s.length();
        // int ans = 0;
        // for (int i = 0; i < n; i++) {
        //     HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        //     int max = Integer.MIN_VALUE;
        //     for (int j = i; j < n; j++) {
        //         char curr = s.charAt(j);
        //         int occ = hm.getOrDefault(curr, 0) + 1;
        //         hm.put(curr, occ);
        //         max = Math.max(occ, max);
        //         int len = j - i + 1;
        //         if ((len - max) <= k) {
        //             ans = Math.max(ans, len);
        //         } else {
        //             break;
        //         }
        //     }
        // }
        // return ans;


        /*
        Approach 2: Sliding window with while loop
        Intuition: Keep a sliding window [left, right]. Track character counts and the highest frequency inside the window.
        If the window becomes invalid (needs more than k replacements), shrink it using a while loop until it is valid again.
        Always update the max length of a valid window.
        Time complexity: O(n), each character enters and leaves the window at most once.
        Space complexity: O(1) since we only store counts of 26 characters.
        */

        // int left = 0;
        // int right = 0;
        // int n = s.length();
        // int ans = 0;
        // HashMap<Character, Integer> hm = new HashMap<>();
        // int max = 0;
        // while (right < n) {
        //     char curr = s.charAt(right);
        //     int occ = hm.getOrDefault(curr, 0) + 1;
        //     hm.put(curr, occ);
        //     max = Math.max(occ, max);
        //     while (((right - left + 1) - max) > k) {
        //         char l = s.charAt(left);
        //         int rem = hm.getOrDefault(l, 0) - 1;
        //         if (rem < 0) {
        //             hm.remove(l);
        //         } else {
        //             hm.put(l, rem);
        //         }
        //         left++;
        //     }
        //     ans = Math.max(ans, (right - left + 1));
        //     right++;
        // }
        // return ans;


        /*
        Approach 3: Sliding window without while loop
        Intuition: Same idea as approach 2, but instead of shrinking the window with a while loop,
        we just move left once whenever the window is invalid. This still works because after shifting left,
        the window will either be valid or will become valid after further iterations.
        Example: For s = "AABABBA" and k = 1, when the window exceeds the allowed replacements,
        moving left once makes the window valid again for future iterations.
        Time complexity: O(n).
        Space complexity: O(1).
        */

        int left = 0;
        int right = 0;
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        while (right < n) {
            char curr = s.charAt(right);
            int occ = hm.getOrDefault(curr, 0) + 1;
            hm.put(curr, occ);
            max = Math.max(occ, max);

            if (((right - left + 1) - max) > k) {
                char l = s.charAt(left);
                int rem = hm.getOrDefault(l, 0) - 1;
                if (rem < 0) {
                    hm.remove(l);
                } else {
                    hm.put(l, rem);
                }
                left++;
            }
            if ((right - left + 1) - max <= k) {
                ans = Math.max(ans, (right - left + 1));
            }
            right++;
        }
        return ans;
    }
}
