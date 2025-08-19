class Solution {
    private int countLessThanEqualToK(int arr[], int n, int goal){
        if(goal<0) return 0;
        int left = 0, right = 0, sum = 0, ans = 0;
        while(right<n){
            sum+=(arr[right]%2); // add right
            while(sum>goal){
                sum-=(arr[left++]%2);
            }
            ans+=(right-left+1);
            right++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        /**
        BRUTE FORCE 
        Time - O(n^2), Space - O(1)
        */
        // int n = nums.length;
        // int ans = 0;
        // for(int i=0;i<n;i++){
        //     int oddCnt = 0;
        //     for(int j=i;j<n;j++){
        //         if(nums[j]%2==1) oddCnt++;

        //         if(oddCnt>k) break;
        //         if(oddCnt==k) ans++;
        //     }
        // }
        // return ans;


        /**
        Better - O(2(n^2)), Space - O(1)
        we keep track of first odd ptr at every valid window and find valid subarrays
         */

        // int l = 0, r = 0, oddCnt = 0, ans = 0, firstSeen = -1;
        // int n = nums.length;
        // while(r<n){
        //     if(nums[r]%2==1){
        //         if(firstSeen==-1) firstSeen = r;
        //         oddCnt++;
        //     }

        //     while(oddCnt>k){
        //         if(nums[l++]%2==1){
        //             oddCnt--;
        //         }
        //     }
        //     firstSeen = -1;
        //     // find firstOdd in l..r
        //     int t = l;
        //     while(t<=r){
        //         if(nums[t]%2==1){
        //             firstSeen = t;
        //             break;
        //         }
        //         t++;
        //     }

        //     if(oddCnt==k){
        //         ans+=(firstSeen-l+1);
        //     }
        //     r++;
        // }
        // return ans;

        /**
        OPTIMAL
        Time - O(2*2n), Space = O(1)

        Same as binary subarrays with sum, just do mod 2 and use array values
         */
        int n = nums.length;
        return countLessThanEqualToK(nums, n, k) - countLessThanEqualToK(nums, n, k-1);
    }
}