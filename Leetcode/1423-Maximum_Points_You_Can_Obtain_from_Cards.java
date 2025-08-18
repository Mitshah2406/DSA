class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // This is a fixed size sliding window problem
        // We can define window as (n-k) size min window
        // if we find out this window
        // then (sum of all - window sum) = our ans
        // Time complexity O(2n), Space- O(1)
        int ws = n-k;
        int sum = 0;
        int ans = 0;
        for(int i:cardPoints){
            sum+=i;
        }
        int wSum = 0;
        for(int i=0;i<ws;i++){
            wSum+=cardPoints[i];
        }
        ans = wSum;
        int left = 0;
        int right = ws;
        while(right<n){
            // remove left
            wSum-=cardPoints[left++];
            wSum+=cardPoints[right++];

            ans = Math.min(ans, wSum);
        }
        
        return sum-ans;
    }
}

