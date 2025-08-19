class Solution {
    private int countLessThanEqualToK(int arr[], int n, int goal){
        if(goal<0) return 0;
        int left = 0, right = 0, sum = 0, ans = 0;
        while(right<n){
            sum+=arr[right]; // add right
            while(sum>goal){
                sum-=arr[left++];
            }
            ans+=(right-left+1);
            right++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {

        /*
        BRUTE
        Time - O(n^2), Space - O(1)
        Count running sum starting from i to j, run till sum <= goal, 
        once exceeds no point going further with that i, so break
         */
        // int n = nums.length;
        // int ans = 0;
        // for(int i=0;i<n;i++){
        //     int sum = 0;
        //     for(int j=i;j<n;j++){
        //         sum+=nums[j];
        //         if(sum==goal){
        //             ans++;
        //         }else if(sum>goal){
        //             break;
        //         }
        //     }
        // }

        // return ans;


        /**
        THIS WONT WORK, like temporarily moving left ptr forward fro skipping zero
         */

        // int n = nums.length;
        // int left = 0;
        // int right = 0;
        // int sum = 0;
        // int ans = 0;
        // while(right<n){
        //     sum+=nums[right];
        //     // prune the window
        //     while(sum>goal){
        //         sum-=nums[left++];
        //     }
        //     // Now count the subarrays
        //     int temp = left;
        //     int tempSum = sum;
        //     while(tempSum==goal && temp<n){
        //         ans++;
        //         tempSum-=nums[temp];
        //         temp++;
        //     }
        //     right++;
        // }

        // return ans;


        /**
        OPTIMAL

        tc = O(2*2n), sc - O(1)

        no of subarrays equal to k = (no of subarrays <= k) - (no of subarrays <= k-1)
         */
        int n = nums.length;
        return countLessThanEqualToK(nums,n,goal) - countLessThanEqualToK(nums,n,goal-1);
    }
}