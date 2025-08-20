class Solution {
    public double findMaxAverage(int[] nums, int k) {
        /**
        BRUTE FORCE
        Just run a n^2 loop for all subarrays, time would be O(n^2), space would be O(1)
         */


        /**
        OPTIMAL - as k is given, we can see that it is a fixed size sliding window problem
        Time - O(N), Space - O(1)
         */
        int n = nums.length;
        double sum = 0.0;
        double avg = 0.0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        avg = sum / (double) k;

        for (int i = k; i < n; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            double newAvg = sum / (double) k;
            if (avg < newAvg) {
                avg = newAvg;
            }
        }
        return avg;
    }
}