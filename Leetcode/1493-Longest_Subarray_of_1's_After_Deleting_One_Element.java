class Solution {
    private int brute(int arr[], int n) {
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = i; j < n; j++) {
                ones += arr[j];
                if ((j - i + 1) == ones + 1) {
                    ans = Math.max(ans, ones);
                }
            }
        }

        return ans == -1 ? n - 1 : ans;
    }

    private int optimal(int arr[], int n) {
        int left = 0, right = 0, ans = -1, zeroes = 0;

        while (right < n) {
            if(arr[right]==0){
                zeroes++;
            }
            while (left < right && zeroes>1) {
                if(arr[left]==0){
                    zeroes--;
                }
                left++;
            }
            ans = Math.max(ans, right-left+1-1); // -1 for deleting one element always
            right++;
        }

        return ans == n ? n - 1 : ans;
    }

    public int longestSubarray(int[] nums) {
        int n = nums.length;

        // return brute(nums, n);
        return optimal(nums, n);
    }
}