class Solution {
    public int maxScore(int[] cardPoints, int k) {

        /**
         *  Approach 1: Sliding Window 
         *
         * Intuition:
         * - We need to select exactly k cards from either the beginning or the end.
         * - This is equivalent to "removing" (n - k) consecutive cards from the middle.
         * - So instead of directly maximizing k chosen cards, we minimize the sum of the 
         *   window of size (n - k).
         * - Final Answer = (Total sum of array) - (Minimum window sum of size n-k).
         *
         * Time Complexity: O(n) -> one pass to compute total + one pass for sliding window.
         * Space Complexity: O(1) -> only using a few variables.
         */
        
        // int n = cardPoints.length;
        // int ws = n - k;  // size of window to remove
        // int sum = 0;
        // for(int i : cardPoints) sum += i;  // total sum
        //
        // int wSum = 0;
        // for(int i=0; i<ws; i++) wSum += cardPoints[i]; // first window sum
        //
        // int minWindow = wSum;
        // int left = 0, right = ws;
        //
        // while(right < n) {
        //     wSum -= cardPoints[left++];  // remove left element
        //     wSum += cardPoints[right++]; // add right element
        //     minWindow = Math.min(minWindow, wSum);
        // }
        //
        // return sum - minWindow;


        /**
         * Approach 2: Prefix + Suffix (Greedy)
         *
         * Intuition:
         * - Another way is to try taking x cards from the left and (k - x) cards from the right.
         * - Start with taking all k cards from the left -> sum = lSum.
         * - Then, gradually shift one card from the left side to the right side.
         * - At each step, compute total = left sum + right sum and update maximum.
         *
         * Time Complexity: O(k) -> we only shift k times at max.
         * Space Complexity: O(1) -> only variables for sums.
         */
        
        int n = cardPoints.length;

        int lSum = 0, rSum = 0;
        int sum = 0, ans = 0;

        // Take first k cards from left initially
        for(int i=0; i<k; i++) lSum += cardPoints[i];

        sum = lSum;
        ans = sum;

        int i = k - 1;    // left pointer
        int rIdx = n - 1; // right pointer

        // Gradually replace cards from left with right
        while(i >= 0) {
            lSum -= cardPoints[i--];   // remove left card
            rSum += cardPoints[rIdx--]; // add right card
            sum = lSum + rSum;
            ans = Math.max(sum, ans);
        }
        
        return ans;
    }
}
