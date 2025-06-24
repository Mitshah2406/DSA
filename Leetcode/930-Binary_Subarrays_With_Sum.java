class Solution {
    // two pointer technique to find subarrays with sum <= goal
    public int temp(int[] nums, int goal) {
        if(goal<0) return 0;
        int l= 0;
        int r = 0;
        int sum = 0;
        int cut = 0;
        int n = nums.length;
        while(r<n){
            sum+=nums[r];

            while(sum>goal){
                sum = sum - nums[l];
                l++;
            }
            cut = cut + (r-l+1); // right to left inclusive subarray consider
            r = r+1;
        }

        return cut;
    }
    public int numSubarraysWithSum(int nums[], int goal){
        // find <=goal - <=goal-1 = =goal
        return temp(nums,goal) - temp(nums,goal-1);
    }
}